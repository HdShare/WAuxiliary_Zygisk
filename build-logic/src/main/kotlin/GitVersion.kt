import org.eclipse.jgit.api.Git
import org.eclipse.jgit.internal.storage.file.FileRepository
import org.gradle.api.Project

object GitVersion {
    private fun getGitInfo(project: Project): Pair<Int?, String?> {
        return try {
            val gitDir = project.rootProject.file(".git")
            if (!gitDir.exists()) return Pair(null, null)
            FileRepository(gitDir).use { repo ->
                Git(repo).use { git ->
                    val ref = repo.resolve("HEAD")
                    val commitCount = git.log().add(ref).call().count()
                    val shortHash = ref.name.substring(0, 7)
                    Pair(commitCount, shortHash)
                }
            }
        } catch (e: Exception) {
            project.logger.warn("Get GitInfo Failed: ${e.message}")
            Pair(null, null)
        }
    }

    fun getBuildVersionCode(project: Project, fallback: Int = 1): Int {
        return getGitInfo(project).first ?: fallback
    }

    fun getGitHeadRefsSuffix(project: Project, fallback: String = ".standalone"): String {
        val (count, hash) = getGitInfo(project)
        return if (count != null && hash != null) ".r$count.${hash.take(7)}" else fallback
    }

    fun getBuildVersionName(project: Project): String {
        return BuildVersion.versionName + getGitHeadRefsSuffix(project)
    }
}

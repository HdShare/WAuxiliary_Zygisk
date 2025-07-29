import org.gradle.api.JavaVersion

object BuildVersion {
    val java = JavaVersion.VERSION_17

    const val minSdk = 27
    const val targetSdk = 35
    const val compileSdk = 35

    const val cmakeVersion = "3.22.1"
    const val ndkVersion = "28.0.13004108"

    const val versionName = "1.0.0"
}

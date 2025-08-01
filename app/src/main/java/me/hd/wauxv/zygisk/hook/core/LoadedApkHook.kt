package me.hd.wauxv.zygisk.hook.core

import com.highcapable.kavaref.KavaRef.Companion.asResolver
import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import com.v7878.vmtools.Hooks.EntryPointType
import me.hd.wauxv.zygisk.hook.util.WLog
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object LoadedApkHook {
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun createOrUpdateClassLoaderLocked(loadedApk: Any, addedPaths: Any?) {
        createOrUpdateClassLoaderLocked(loadedApk, addedPaths)
        try {
            val packageName = loadedApk.asResolver().firstField { name = "mPackageName" }.get<String>()!!
            val classloader = loadedApk.asResolver().firstField { name = "mClassLoader" }.get<ClassLoader>()!!
            ApplicationHook.init(packageName, classloader)
        } catch (th: Throwable) {
            WLog.error("LoadedApkHook Failed", th)
        }
    }

    fun init() {
        val target = "android.app.LoadedApk".toClass().resolve().firstMethod { name = "createOrUpdateClassLoaderLocked" }
        val hooker = LoadedApkHook::class.resolve().firstMethod { name = "createOrUpdateClassLoaderLocked" }
        Hooks.hookSwap(target.self, EntryPointType.CURRENT, hooker.self, EntryPointType.DIRECT)
    }
}

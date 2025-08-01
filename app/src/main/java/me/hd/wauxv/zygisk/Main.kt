package me.hd.wauxv.zygisk

import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotObfuscateType
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.r8.annotations.DoNotShrinkType
import me.hd.wauxv.zygisk.hook.core.LoadedApkHook
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
@DoNotShrinkType
@DoNotObfuscateType
object Main {
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    @Throws(Throwable::class)
    fun premain() {
        System.loadLibrary("wauxv-zygisk")
    }

    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    @Throws(Throwable::class)
    fun main() {
        LoadedApkHook.init()
    }
}

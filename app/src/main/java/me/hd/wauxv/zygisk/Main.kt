package me.hd.wauxv.zygisk

import android.util.Log
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotObfuscateType
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.r8.annotations.DoNotShrinkType
import me.hd.wauxv.zygisk.hook.LoadedApkHook
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
@DoNotShrinkType
@DoNotObfuscateType
object Main {
    var TAG: String = "WAuxiliary"

    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    fun main() {
        try {
            LoadedApkHook.init()
        } catch (th: Throwable) {
            Log.e(TAG, "Throwable", th)
        }
    }
}

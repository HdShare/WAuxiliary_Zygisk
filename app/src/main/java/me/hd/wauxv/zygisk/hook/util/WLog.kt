package me.hd.wauxv.zygisk.hook.util

import android.util.Log
import com.v7878.zygisk.ZygoteLoader
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object WLog {
    private const val LSP = "LSPosed"
    private const val TAG = "WAuxv Zygisk"

    private data class WLogData(
        val tag: String = TAG,
        val priority: String = "",
        var packageName: String = ZygoteLoader.getPackageName(),
        var msg: String = "",
        var throwable: Throwable? = null
    ) {
        override fun toString() = "[$tag][$priority][$packageName] $msg"
    }

    private fun log(data: WLogData) {
        when (data.priority) {
            "D" -> Log.d(LSP, data.toString(), data.throwable)
            "I" -> Log.i(LSP, data.toString(), data.throwable)
            "W" -> Log.w(LSP, data.toString(), data.throwable)
            "E" -> Log.e(LSP, data.toString(), data.throwable)
            else -> Log.wtf(LSP, data.toString(), data.throwable)
        }
    }

    fun debug(msg: Any? = null, e: Throwable? = null) {
        log(WLogData(priority = "D", msg = msg.toString(), throwable = e))
    }

    fun info(msg: Any? = null, e: Throwable? = null) {
        log(WLogData(priority = "I", msg = msg.toString(), throwable = e))
    }

    fun warn(msg: Any? = null, e: Throwable? = null) {
        log(WLogData(priority = "W", msg = msg.toString(), throwable = e))
    }

    fun error(msg: Any? = null, e: Throwable? = null) {
        log(WLogData(priority = "E", msg = msg.toString(), throwable = e))
    }
}

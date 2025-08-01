package me.hd.wauxv.zygisk.hook.apps.qq.base

import me.hd.wauxv.zygisk.hook.util.WLog

abstract class BaseHooker {
    abstract val name: String

    abstract fun onLoad()

    fun load() {
        try {
            onLoad()
        } catch (th: Throwable) {
            WLog.error("onLoad $name Failed", th)
        }
    }
}

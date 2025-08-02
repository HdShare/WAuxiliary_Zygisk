package me.hd.wauxv.zygisk.hook.apps.wx.base

import me.hd.wauxv.zygisk.hook.util.WLog

abstract class BaseHooker {
    private var init = false
    abstract val name: String
    abstract fun initOnce()

    fun load() {
        if (init) return
        try {
            initOnce()
        } catch (th: Throwable) {
            WLog.error("initOnce $name Failed", th)
        }
        init = true
    }
}

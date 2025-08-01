package me.hd.wauxv.zygisk.hook.apps.wx.base

abstract class BaseHooker {
    abstract val name: String

    abstract fun load()
}

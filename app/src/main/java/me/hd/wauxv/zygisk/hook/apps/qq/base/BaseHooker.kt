package me.hd.wauxv.zygisk.hook.apps.qq.base

abstract class BaseHooker {
    abstract val name: String

    abstract fun load()
}

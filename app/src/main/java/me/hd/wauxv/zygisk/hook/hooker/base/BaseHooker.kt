package me.hd.wauxv.zygisk.hook.hooker.base

abstract class BaseHooker {
    abstract val name: String
    abstract fun load(loader: ClassLoader)
}

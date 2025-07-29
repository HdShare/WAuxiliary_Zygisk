package me.hd.wauxv.zygisk.hook.hooker.wx

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import me.hd.wauxv.zygisk.hook.hooker.base.BaseHooker
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object AntiRevokeHooker : BaseHooker() {
    override val name = "阻止消息撤回"

    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun doRevokeMsg() {
    }

    override fun load(loader: ClassLoader) {
        val target = "bi0.s".toClass(loader).resolve().firstMethod { name = "h" }
        val hooker = AntiRevokeHooker::class.resolve().firstMethod { name = "doRevokeMsg" }
        Hooks.hook(target.self, hooker.self, Hooks.EntryPointType.DIRECT)
    }
}

package me.hd.wauxv.zygisk.hook.entry.hooker.wx

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import me.hd.wauxv.zygisk.hook.entry.hooker.base.BaseHooker
import me.hd.wauxv.zygisk.hook.entry.hooker.wx.data.WxVerData
import me.hd.wauxv.zygisk.hook.entry.hooker.wx.data.WxVerData.WxVersion
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object AntiRevokeHooker : BaseHooker() {
    override val name = "阻止消息撤回"

    @Suppress("unused")
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun doRevokeMsg() {
    }

    override fun load(loader: ClassLoader) {
        val target = when {
            WxVerData.isAtLeast(WxVersion.V8_0_62) -> "fs0.s".toClass(loader).resolve().firstMethod { name = "k" }
            WxVerData.isAtLeast(WxVersion.V8_0_61) -> "pr0.s".toClass(loader).resolve().firstMethod { name = "m" }
            WxVerData.isAtLeast(WxVersion.V8_0_60) -> "wq0.s".toClass(loader).resolve().firstMethod { name = "l" }
            WxVerData.isAtLeast(WxVersion.V8_0_58) -> "fq0.t".toClass(loader).resolve().firstMethod { name = "k" }
            WxVerData.isAtLeast(WxVersion.V8_0_57) -> "oo0.t".toClass(loader).resolve().firstMethod { name = "l" }
            WxVerData.isAtLeast(WxVersion.V8_0_56) -> "vn0.t".toClass(loader).resolve().firstMethod { name = "m" }
            WxVerData.isAtLeast(WxVersion.V8_0_55) -> "nm0.t".toClass(loader).resolve().firstMethod { name = "k" }
            WxVerData.isAtLeast(WxVersion.V8_0_54) -> "an0.s".toClass(loader).resolve().firstMethod { name = "k" }
            WxVerData.isAtLeast(WxVersion.V8_0_53) -> "zm0.t".toClass(loader).resolve().firstMethod { name = "k" }
            WxVerData.isAtLeast(WxVersion.V8_0_51) -> "tm0.t".toClass(loader).resolve().firstMethod { name = "k" }
            WxVerData.isAtLeast(WxVersion.V8_0_50) -> "ik0.t".toClass(loader).resolve().firstMethod { name = "k" }
            WxVerData.isAtLeast(WxVersion.V8_0_49) -> "tj0.s".toClass(loader).resolve().firstMethod { name = "h" }
            WxVerData.isAtLeast(WxVersion.V8_0_48) -> "ij0.s".toClass(loader).resolve().firstMethod { name = "i" }
            WxVerData.isAtLeast(WxVersion.V8_0_47) -> "ri0.t".toClass(loader).resolve().firstMethod { name = "h" }
            WxVerData.isAtLeast(WxVersion.V8_0_46) -> "ri0.t".toClass(loader).resolve().firstMethod { name = "h" }
            WxVerData.isAtLeast(WxVersion.V8_0_45) -> "bi0.s".toClass(loader).resolve().firstMethod { name = "h" }
            WxVerData.isAtLeast(WxVersion.V8_0_44) -> "sh0.s".toClass(loader).resolve().firstMethod { name = "n" }
            WxVerData.isAtLeast(WxVersion.V8_0_43) -> "of0.g".toClass(loader).resolve().firstMethod { name = "q" }
            WxVerData.isAtLeast(WxVersion.V8_0_42) -> "nf0.g".toClass(loader).resolve().firstMethod { name = "q" }
            WxVerData.isAtLeast(WxVersion.V8_0_41) -> "kd0.g".toClass(loader).resolve().firstMethod { name = "q" }
            WxVerData.isAtLeast(WxVersion.V8_0_40) -> "wc0.g".toClass(loader).resolve().firstMethod { name = "z" }
            else -> return
        }
        val hooker = AntiRevokeHooker::class.resolve().firstMethod { name = "doRevokeMsg" }
        Hooks.hook(target.self, hooker.self, Hooks.EntryPointType.DIRECT)
    }
}

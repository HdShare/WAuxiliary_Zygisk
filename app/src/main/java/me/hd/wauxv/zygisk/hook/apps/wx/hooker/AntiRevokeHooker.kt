package me.hd.wauxv.zygisk.hook.apps.wx.hooker

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import me.hd.wauxv.zygisk.hook.apps.wx.base.BaseHooker
import me.hd.wauxv.zygisk.hook.apps.wx.data.HostData.toAppClass
import me.hd.wauxv.zygisk.hook.apps.wx.data.VerData
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

    override fun onLoad() {
        val target = when {
            VerData.isAtLeast(VerData.Version.V8_0_62) -> "fs0.s".toAppClass().resolve().firstMethod { name = "k" }
            VerData.isAtLeast(VerData.Version.V8_0_61) -> "pr0.s".toAppClass().resolve().firstMethod { name = "m" }
            VerData.isAtLeast(VerData.Version.V8_0_60) -> "wq0.s".toAppClass().resolve().firstMethod { name = "l" }
            VerData.isAtLeast(VerData.Version.V8_0_58) -> "fq0.t".toAppClass().resolve().firstMethod { name = "k" }
            VerData.isAtLeast(VerData.Version.V8_0_57) -> "oo0.t".toAppClass().resolve().firstMethod { name = "l" }
            VerData.isAtLeast(VerData.Version.V8_0_56) -> "vn0.t".toAppClass().resolve().firstMethod { name = "m" }
            VerData.isAtLeast(VerData.Version.V8_0_55) -> "nm0.t".toAppClass().resolve().firstMethod { name = "k" }
            VerData.isAtLeast(VerData.Version.V8_0_54) -> "an0.s".toAppClass().resolve().firstMethod { name = "k" }
            VerData.isAtLeast(VerData.Version.V8_0_53) -> "zm0.t".toAppClass().resolve().firstMethod { name = "k" }
            VerData.isAtLeast(VerData.Version.V8_0_51) -> "tm0.t".toAppClass().resolve().firstMethod { name = "k" }
            VerData.isAtLeast(VerData.Version.V8_0_50) -> "ik0.t".toAppClass().resolve().firstMethod { name = "k" }
            VerData.isAtLeast(VerData.Version.V8_0_49) -> "tj0.s".toAppClass().resolve().firstMethod { name = "h" }
            VerData.isAtLeast(VerData.Version.V8_0_48) -> "ij0.s".toAppClass().resolve().firstMethod { name = "i" }
            VerData.isAtLeast(VerData.Version.V8_0_47) -> "ri0.t".toAppClass().resolve().firstMethod { name = "h" }
            VerData.isAtLeast(VerData.Version.V8_0_46) -> "ri0.t".toAppClass().resolve().firstMethod { name = "h" }
            VerData.isAtLeast(VerData.Version.V8_0_45) -> "bi0.s".toAppClass().resolve().firstMethod { name = "h" }
            VerData.isAtLeast(VerData.Version.V8_0_44) -> "sh0.s".toAppClass().resolve().firstMethod { name = "n" }
            VerData.isAtLeast(VerData.Version.V8_0_43) -> "of0.g".toAppClass().resolve().firstMethod { name = "q" }
            VerData.isAtLeast(VerData.Version.V8_0_42) -> "nf0.g".toAppClass().resolve().firstMethod { name = "q" }
            VerData.isAtLeast(VerData.Version.V8_0_41) -> "kd0.g".toAppClass().resolve().firstMethod { name = "q" }
            VerData.isAtLeast(VerData.Version.V8_0_40) -> "wc0.g".toAppClass().resolve().firstMethod { name = "z" }
            else -> return
        }
        val hooker = AntiRevokeHooker::class.resolve().firstMethod { name = "doRevokeMsg" }
        Hooks.hook(target.self, hooker.self, Hooks.EntryPointType.DIRECT)
    }
}

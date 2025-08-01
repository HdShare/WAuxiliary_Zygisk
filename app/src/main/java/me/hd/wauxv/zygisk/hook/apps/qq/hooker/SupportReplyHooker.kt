package me.hd.wauxv.zygisk.hook.apps.qq.hooker

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import me.hd.wauxv.zygisk.hook.apps.qq.base.BaseHooker
import me.hd.wauxv.zygisk.hook.apps.qq.data.HostData.toAppClass
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object SupportReplyHooker : BaseHooker() {
    override val name = "左滑回复限制"

    @Suppress("unused")
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun isSupportReply(): Boolean {
        return true
    }

    override fun onLoad() {
        val target = "com.tencent.mobileqq.ark.api.impl.ArkHelperImpl".toAppClass().resolve().firstMethod { name = "isSupportReply" }
        val hooker = SupportReplyHooker::class.resolve().firstMethod { name = "isSupportReply" }
        Hooks.hook(target.self, hooker.self, Hooks.EntryPointType.DIRECT)
    }
}

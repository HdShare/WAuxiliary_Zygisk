package me.hd.wauxv.zygisk.hook.entry.hooker.qq

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import me.hd.wauxv.zygisk.hook.entry.hooker.base.BaseHooker
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

    override fun load(loader: ClassLoader) {
        val target = "com.tencent.mobileqq.ark.api.impl.ArkHelperImpl".toClass(loader).resolve().firstMethod { name = "isSupportReply" }
        val hooker = SupportReplyHooker::class.resolve().firstMethod { name = "isSupportReply" }
        Hooks.hook(target.self, hooker.self, Hooks.EntryPointType.DIRECT)
    }
}

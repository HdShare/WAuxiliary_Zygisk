package me.hd.wauxv.zygisk.hook.apps.qq.hooker

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import com.v7878.vmtools.Hooks.EntryPointType
import me.hd.wauxv.zygisk.hook.apps.qq.base.BaseHooker
import me.hd.wauxv.zygisk.hook.apps.qq.data.HostData.toAppClass
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object EmoReplyMenuHooker : BaseHooker() {
    override val name = "消息表态菜单"

    @Suppress("unused")
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun getEmoReplyMenuView() {
    }

    override fun initOnce() {
        val target = "com.tencent.qqnt.aio.api.impl.AIOEmoReplyMenuApiImpl".toAppClass().resolve().firstMethod { name = "getEmoReplyMenuView" }
        val hooker = EmoReplyMenuHooker::class.resolve().firstMethod { name = "getEmoReplyMenuView" }
        Hooks.hook(target.self, hooker.self, EntryPointType.DIRECT)
    }
}

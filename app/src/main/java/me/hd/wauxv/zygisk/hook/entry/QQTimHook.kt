package me.hd.wauxv.zygisk.hook.entry

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object QQTimHook {
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun isSupportReply(): Boolean {
        return true
    }

    // 左滑回复限制
    fun init(classloader: ClassLoader) {
        val target = "com.tencent.mobileqq.ark.api.impl.ArkHelperImpl".toClass(classloader).resolve().firstMethod { name = "isSupportReply" }.self
        val hooker = QQTimHook::class.resolve().firstMethod { name = "isSupportReply" }.self
        Hooks.hook(target, hooker, Hooks.EntryPointType.DIRECT)
    }
}

package me.hd.wauxv.zygisk.hook.entry

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object WechatHook {
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun h() {
    }

    // 防撤回
    fun init(classloader: ClassLoader) {
        val target = "bi0.s".toClass(classloader).resolve().firstMethod { name = "h" }.self
        val hooker = WechatHook::class.resolve().firstMethod { name = "h" }.self
        Hooks.hook(target, hooker, Hooks.EntryPointType.DIRECT)
    }
}

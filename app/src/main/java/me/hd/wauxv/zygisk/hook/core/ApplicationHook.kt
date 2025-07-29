package me.hd.wauxv.zygisk.hook.core

import me.hd.wauxv.zygisk.hook.entry.QQTimHook
import me.hd.wauxv.zygisk.hook.entry.WechatHook
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object ApplicationHook {
    fun init(packageName: String, classloader: ClassLoader) {
        when (packageName) {
            "com.tencent.mm" -> WechatHook.init(classloader)
            "com.tencent.mobileqq", "com.tencent.tim" -> QQTimHook.init(classloader)
        }
    }
}

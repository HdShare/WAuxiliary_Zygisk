package me.hd.wauxv.zygisk.hook.core

import me.hd.wauxv.zygisk.hook.entry.QQTimEntry
import me.hd.wauxv.zygisk.hook.entry.WechatEntry
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object ApplicationHook {
    fun init(packageName: String, classloader: ClassLoader) {
        when (packageName) {
            "com.tencent.mm" -> WechatEntry.init(classloader)
            "com.tencent.mobileqq", "com.tencent.tim" -> QQTimEntry.init(classloader)
        }
    }
}

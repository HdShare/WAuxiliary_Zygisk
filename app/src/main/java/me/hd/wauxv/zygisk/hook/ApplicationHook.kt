package me.hd.wauxv.zygisk.hook

import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object ApplicationHook {
    fun init(packageName: String, classloader: ClassLoader) {
        if (packageName == "com.tencent.mm") {
            WechatHook.init(classloader)
        }
    }
}

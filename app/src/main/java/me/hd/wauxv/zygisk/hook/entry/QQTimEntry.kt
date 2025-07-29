package me.hd.wauxv.zygisk.hook.entry

import me.hd.wauxv.zygisk.hook.entry.hooker.qq.SupportReplyHooker
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object QQTimEntry {
    fun init(loader: ClassLoader) {
        SupportReplyHooker.load(loader)
    }
}

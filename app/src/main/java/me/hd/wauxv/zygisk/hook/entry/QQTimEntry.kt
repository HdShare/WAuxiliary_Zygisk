package me.hd.wauxv.zygisk.hook.entry

import me.hd.wauxv.zygisk.hook.hooker.qq.SupportReplyHooker
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object QQTimEntry {
    fun load(loader: ClassLoader) {
        SupportReplyHooker.load(loader)
    }
}

package me.hd.wauxv.zygisk.hook.apps.qq

import me.hd.wauxv.zygisk.hook.apps.qq.data.HostData
import me.hd.wauxv.zygisk.hook.apps.qq.hooker.EmoReplyMenuHooker
import me.hd.wauxv.zygisk.hook.apps.qq.hooker.SupportReplyHooker
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object QQTimEntry {
    fun init(loader: ClassLoader) {
        HostData.init(loader)
        listOf(
            SupportReplyHooker,
            EmoReplyMenuHooker,
        ).forEach { hooker ->
            hooker.load()
        }
    }
}

package me.hd.wauxv.zygisk.hook.apps.qq

import me.hd.wauxv.zygisk.hook.apps.qq.data.HostData
import me.hd.wauxv.zygisk.hook.apps.qq.hooker.EmoReplyMenuHooker
import me.hd.wauxv.zygisk.hook.apps.qq.hooker.SupportReplyHooker
import me.hd.wauxv.zygisk.hook.util.WLog
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object QQTimEntry {
    fun init(loader: ClassLoader) {
        HostData.init(loader)
        WLog.info("running on: ${HostData.toVerStr()}")
        listOf(
            SupportReplyHooker,
            EmoReplyMenuHooker,
        ).forEach { hooker ->
            hooker.load()
        }
    }
}

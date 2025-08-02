package me.hd.wauxv.zygisk.hook.apps.wx

import me.hd.wauxv.zygisk.hook.apps.wx.data.HostData
import me.hd.wauxv.zygisk.hook.apps.wx.hooker.AntiRevokeHooker
import me.hd.wauxv.zygisk.hook.util.WLog
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object WechatEntry {
    fun init(loader: ClassLoader) {
        HostData.init(loader)
        WLog.info("running on: ${HostData.toVerStr()}")
        listOf(
            AntiRevokeHooker,
        ).forEach { hooker ->
            hooker.load()
        }
    }
}

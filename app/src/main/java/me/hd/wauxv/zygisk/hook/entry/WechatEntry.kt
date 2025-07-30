package me.hd.wauxv.zygisk.hook.entry

import me.hd.wauxv.zygisk.hook.entry.hooker.wx.AntiRevokeHooker
import me.hd.wauxv.zygisk.hook.entry.hooker.wx.data.WxHostData
import me.hd.wauxv.zygisk.hook.util.WLog
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object WechatEntry {
    fun init(loader: ClassLoader) {
        WxHostData.init(loader)
        WLog.info("running on: ${WxHostData.toVerStr()}")
        AntiRevokeHooker.load(loader)
    }
}

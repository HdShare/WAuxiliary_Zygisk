package me.hd.wauxv.zygisk.hook.entry

import me.hd.wauxv.zygisk.hook.entry.hooker.wx.data.WxHostData
import me.hd.wauxv.zygisk.hook.entry.hooker.wx.AntiRevokeHooker
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object WechatEntry {
    fun init(loader: ClassLoader) {
        WxHostData.init(loader)
        AntiRevokeHooker.load(loader)
    }
}

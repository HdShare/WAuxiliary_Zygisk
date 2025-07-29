package me.hd.wauxv.zygisk.hook.entry

import me.hd.wauxv.zygisk.hook.hooker.wx.AntiRevokeHooker
import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object WechatEntry {
    fun load(loader: ClassLoader) {
        AntiRevokeHooker.load(loader)
    }
}

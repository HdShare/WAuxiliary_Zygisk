package me.hd.wauxv.zygisk.hook.apps.wx.data

import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object VerData {
    enum class Version(val code: Int) {
        V8_0_40(2420),
        V8_0_41(2440),
        V8_0_42(2460),
        V8_0_43(2480),
        V8_0_44(2500),
        V8_0_45(2520),
        V8_0_46(2540),
        V8_0_47(2560),
        V8_0_48(2580),
        V8_0_49(2600),
        V8_0_50(2620),
        V8_0_51(2720),
        V8_0_53(2740),
        V8_0_54(2760),
        V8_0_55(2780),
        V8_0_56(2800),
        V8_0_57(2820),
        V8_0_58(2840),
        V8_0_60(2860),
        V8_0_61(2880),
        V8_0_62(2900),
    }

    fun isAtLeast(version: Version) = !HostData.isPlay && HostData.verCode >= version.code

    @Obfuscate
    enum class PlayVersion(val code: Int) {
        V8_0_41(2420),
        V8_0_48(2580),
        V8_0_49(2680),
        V8_0_51(2700),
        V8_0_54(2740),
        V8_0_56(2780),
        V8_0_57(2800),
        V8_0_58(2820),
        V8_0_60(2840),
        V8_0_61(2860),
    }

    fun isAtLeastPlay(version: PlayVersion) = HostData.isPlay && HostData.verCode >= version.code
}

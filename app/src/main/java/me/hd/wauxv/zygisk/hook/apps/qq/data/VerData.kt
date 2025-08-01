package me.hd.wauxv.zygisk.hook.apps.qq.data

import org.lsposed.lsparanoid.Obfuscate

@Obfuscate
object VerData {
    enum class QQVersion(val code: Int) {
        V9_0_0(5282),
        V9_1_0(7518),
        V9_2_0(10970),
    }

    enum class TIMVersion(val code: Int) {
        V4_1_0(4050),
    }
}

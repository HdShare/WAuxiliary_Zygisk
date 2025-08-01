package me.hd.wauxv.zygisk.hook.apps.wx.data

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import org.lsposed.lsparanoid.Obfuscate
import kotlin.properties.Delegates

@Obfuscate
object HostData {
    var appClassLoader by Delegates.notNull<ClassLoader>()
    var verName by Delegates.notNull<String>()
    var verCode by Delegates.notNull<Int>()
    var verClient by Delegates.notNull<String>()

    fun String.toAppClass() = toClass(appClassLoader)

    fun init(loader: ClassLoader) {
        appClassLoader = loader
        "com.tencent.mm.boot.BuildConfig".toAppClass().resolve().apply {
            verName = firstField { name = "VERSION_NAME" }.get<String>()!!
            verCode = firstField { name = "VERSION_CODE" }.get<Int>()!!
            verClient = firstField { name = "CLIENT_VERSION_ARM64" }.get<String>()!!
        }
    }

    fun toVerStr() = "$verName($verCode)_$verClient"
}

package me.hd.wauxv.ui

import android.app.Activity
import android.os.Bundle
import android.util.Log
import org.luckypray.dexkit.DexKitBridge

class DexObfActivity : Activity() {
    private fun log(msg: String) {
        Log.i("WAuxiliary", msg)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        System.loadLibrary("dexkit")
        filesDir.listFiles { file ->
            file.isFile && file.name.endsWith(".apk", ignoreCase = true)
        }?.sortedByDescending {
            it.name
        }?.forEach { apk ->
            log("==============================")
            log(apk.name)
            DexKitBridge.create(apk.absolutePath).use { dexKit ->
                dexKit.findMethod {
                    matcher {
                        usingEqStrings("doRevokeMsg xmlSrvMsgId=%d talker=%s isGet=%s")
                    }
                }.singleOrNull()?.let {
                    log(it.descriptor)
                }
            }
        }
    }
}

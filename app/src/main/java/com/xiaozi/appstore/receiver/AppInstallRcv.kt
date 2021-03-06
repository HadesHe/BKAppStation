package com.xiaozi.appstore.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.xiaozi.appstore.component.GlobalData

/**
 * Created by fish on 18-1-5.
 */
class AppInstallRcv : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {
        if (Intent.ACTION_PACKAGE_ADDED == intent?.action) {
            val appPackageName = intent.dataString?.split(":")?.get(1)?.trim()
            if (appPackageName != null) {
                GlobalData.addInstalledApp(appPackageName)
            }
        } else if (Intent.ACTION_PACKAGE_REMOVED == intent?.action) {
            val appPackageName = intent.dataString?.split(":")?.get(1)?.trim()
            if (appPackageName != null) {
                GlobalData.removeInstalledApp(appPackageName)
            }
        }
    }

}
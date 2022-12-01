package com.lifehack.apptestkmm.android

import PlatformConfiguration
import android.app.Application

class LifehackApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun LifehackApp.initPlatformSDK() =
    PlatformSDK.init(
        configuration = PlatformConfiguration(androidContext = applicationContext)
    )
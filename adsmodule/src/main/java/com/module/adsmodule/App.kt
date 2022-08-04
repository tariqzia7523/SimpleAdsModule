package com.module.ads

import android.app.Application
import com.module.adsmodule.R
import com.google.firebase.FirebaseApp
import com.module.adsmodule.AppOpenManager
import com.module.adsmodule.BuildConfig

class App : Application() {
    var appOpenManager: AppOpenManager? = null
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(applicationContext)
        appOpenManager = AppOpenManager(this, MySharedPref(this), BuildConfig.DEBUG)

//        MobileAds.initialize(this) { initializationStatus -> //Showing a simple Toast Message to the user when The Google AdMob Sdk Initialization is Completed
//        }
    }
}
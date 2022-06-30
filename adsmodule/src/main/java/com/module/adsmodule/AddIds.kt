package com.module.ads

import android.app.Activity
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import java.lang.Exception

class AddIds {

    companion object {
        var bannerCounter = 1
        var interstilCounter = 1
        var nativeCounter = 1
    }

    fun getAllids(context: Activity) {
        val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        mFirebaseRemoteConfig.fetch(1)
            .addOnCompleteListener(context, object : OnCompleteListener<Void?> {
                override fun onComplete(task: Task<Void?>) {
                    if (task.isSuccessful()) {
                       // Toast.makeText(context, "Fetch Succeeded", Toast.LENGTH_SHORT).show()
                        Log.e("***Valueis", " Fetch Succeeded ")
                        // After config data is successfully fetched, it must be activated before newly fetched
                        // values are returned.

                        val mySharedPref = MySharedPref(context)
                        val appopnid = mFirebaseRemoteConfig.getString("app_open")
                        Log.e("***Valueis", "The value is " + appopnid)
                        mySharedPref.putString(
                            MySharedPref.APP_OPEN,
                            mFirebaseRemoteConfig.getString(MySharedPref.APP_OPEN)
                        )
                        mySharedPref.putString(
                            MySharedPref.INTERSTITIAL_1,
                            mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_1)
                        )
                        mySharedPref.putString(
                            MySharedPref.INTERSTITIAL_2,
                            mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_2)
                        )
                        mySharedPref.putString(
                            MySharedPref.INTERSTITIAL_3,
                            mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_3)
                        )
                        mySharedPref.putString(
                            MySharedPref.INTERSTITIAL_4,
                            mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_4)
                        )
                        mySharedPref.putString(
                            MySharedPref.NATIVE_1,
                            mFirebaseRemoteConfig.getString(MySharedPref.NATIVE_1)
                        )
                        mySharedPref.putString(
                            MySharedPref.NATIVE_2,
                            mFirebaseRemoteConfig.getString(MySharedPref.NATIVE_2)
                        )
                        mySharedPref.putString(
                            MySharedPref.BANNER_1,
                            mFirebaseRemoteConfig.getString(MySharedPref.BANNER_1)
                        )
                        mySharedPref.putString(MySharedPref.BANNER_2, mFirebaseRemoteConfig.getString(MySharedPref.BANNER_2))
                        mySharedPref.putString(MySharedPref.REWARD_1, mFirebaseRemoteConfig.getString(MySharedPref.REWARD_1))
                        mySharedPref.putString(MySharedPref.REWARD_2, mFirebaseRemoteConfig.getString(MySharedPref.REWARD_2))

                        mySharedPref.putBoolen(MySharedPref.BANNER_CALL, mFirebaseRemoteConfig.getBoolean(MySharedPref.BANNER_CALL))
                        mySharedPref.putBoolen(MySharedPref.INTER_CALL, mFirebaseRemoteConfig.getBoolean(MySharedPref.INTER_CALL))
                        mySharedPref.putBoolen(MySharedPref.NATIVE_CALL, mFirebaseRemoteConfig.getBoolean(MySharedPref.NATIVE_CALL))
                        mySharedPref.putBoolen(MySharedPref.REWARD_CALL, mFirebaseRemoteConfig.getBoolean(MySharedPref.REWARD_CALL))
                        mySharedPref.putBoolen(MySharedPref.APP_OPEN_CALL, mFirebaseRemoteConfig.getBoolean(MySharedPref.APP_OPEN_CALL))


                        Log.e("***Valueis", "saved open app call " + mySharedPref.getBoolen(MySharedPref.APP_OPEN_CALL))
                        Log.e("***Valueis", "saved banner call " + mySharedPref.getBoolen(MySharedPref.BANNER_CALL))
                        Log.e("***Valueis", "saved inter call " + mySharedPref.getBoolen(MySharedPref.INTER_CALL))
                        Log.e("***Valueis", "saved native call " + mySharedPref.getBoolen(MySharedPref.NATIVE_CALL))


                        try{
                            mySharedPref.putInt(MySharedPref.AD_COUNT, mFirebaseRemoteConfig.getString(MySharedPref.AD_COUNT).toInt())
                        }catch (e : Exception){
                            e.printStackTrace()
                        }

                        Log.e(
                            "***Valueis",
                            "saved value " + mySharedPref.getString(MySharedPref.BANNER_2)
                        )


                        mFirebaseRemoteConfig.fetchAndActivate()
                    } else {
                        //Toast.makeText(context, "Fetch Failed", Toast.LENGTH_SHORT).show()
                    }
                   // Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show()
                }
            })
    }

    fun getBannerID(context: Activity,isDubugModeRunnig :Boolean): String {
        var id = ""
        if (isDubugModeRunnig) {
            Log.e("***ADS","banner debug check true")
            return "ca-app-pub-3940256099942544/6300978111" // test id
        }
        Log.e("***ADS","banner debug check false")
        val mySharedPref = MySharedPref(context)
        if (bannerCounter == 1) {
            id = mySharedPref.getString(MySharedPref.BANNER_1)!!
            bannerCounter = 2
        } else {
            bannerCounter = 1
            id = mySharedPref.getString(MySharedPref.BANNER_2)!!
        }
        Log.e("***ADS","banner id "+id)
        return id
    }

    fun getInterstialId(context: Activity,isDubugModeRunnig :Boolean): String {
        var id = ""
        if (isDubugModeRunnig) {
            return "ca-app-pub-3940256099942544/1033173712" // test id
        }
        val mySharedPref = MySharedPref(context)
        if (interstilCounter == 1) {
            id = mySharedPref.getString(MySharedPref.INTERSTITIAL_1)!!
            interstilCounter = 2
        } else if (interstilCounter == 2) {
            id = mySharedPref.getString(MySharedPref.INTERSTITIAL_2)!!
            interstilCounter = 3
        } else if (interstilCounter == 3) {
            id = mySharedPref.getString(MySharedPref.INTERSTITIAL_3)!!
            interstilCounter = 4
        } else {
            interstilCounter = 1
            id = mySharedPref.getString(MySharedPref.INTERSTITIAL_4)!!
        }
        Log.e("***ADS","Inter id "+id)
        return id
    }

    fun getNativeId(context: Activity,isDubugModeRunnig :Boolean): String {
        var id = ""
        if (isDubugModeRunnig) {
            return "ca-app-pub-3940256099942544/2247696110" // test id
        }
        val mySharedPref = MySharedPref(context)
        if (nativeCounter == 1) {
            id = mySharedPref.getString(MySharedPref.NATIVE_1)!!
            nativeCounter = 2
        } else {
            nativeCounter = 1
            id = mySharedPref.getString(MySharedPref.NATIVE_2)!!
        }
        return id
    }

//    val rewardedAd: String
//        get() {
//            var id = ""
//            id = if (BuildConfig.DEBUG) {
//                "ca-app-pub-3940256099942544/5224354917" // test id
//            } else {
//                "ca-app-pub-6247650642874574/8098374846" // orignal id
//            }
//            return id
//        }

    fun gerewardedAdID(context: Activity,isDubugModeRunnig : Boolean): String {
        var id = ""
        if (isDubugModeRunnig) {
            return "ca-app-pub-3940256099942544/5224354917" // test id
        }
        val mySharedPref = MySharedPref(context)
        if (nativeCounter == 1) {
            id = mySharedPref.getString(MySharedPref.NATIVE_1)!!
            nativeCounter = 2
        } else {
            nativeCounter = 1
            id = mySharedPref.getString(MySharedPref.NATIVE_2)!!
        }
        return id
    }

    fun getOpenAppId(mySharedPref: MySharedPref,isDubugModeRunnig : Boolean ): String {
        if (isDubugModeRunnig) {
            return "ca-app-pub-3940256099942544/3419835294" // test id
        }
        return mySharedPref.getString(MySharedPref.APP_OPEN)!!
    }
}


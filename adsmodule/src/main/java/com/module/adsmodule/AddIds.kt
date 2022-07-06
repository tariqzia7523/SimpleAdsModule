package com.module.ads

import android.app.Activity
import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import kotlin.Exception

class AddIds( var isDebugRuning : Boolean) {

    companion object {
        var bannerCounter = 1
        var interstilCounter = 1
        var nativeCounter = 1
    }

//    var isDebugRuning = true

    fun getAllids(context: Activity) {
        FirebaseApp.initializeApp(context)
        val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        mFirebaseRemoteConfig.fetch(0)
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
                        mySharedPref.putString(MySharedPref.APP_OPEN, mFirebaseRemoteConfig.getString(MySharedPref.APP_OPEN))
                        mySharedPref.putString(MySharedPref.INTERSTITIAL_1, mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_1))
                        mySharedPref.putString(MySharedPref.INTERSTITIAL_2, mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_2))
                        mySharedPref.putString(MySharedPref.INTERSTITIAL_3, mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_3))
                        mySharedPref.putString(MySharedPref.INTERSTITIAL_4, mFirebaseRemoteConfig.getString(MySharedPref.INTERSTITIAL_4))
                        mySharedPref.putString(MySharedPref.NATIVE_1, mFirebaseRemoteConfig.getString(MySharedPref.NATIVE_1))
                        mySharedPref.putString(MySharedPref.NATIVE_2, mFirebaseRemoteConfig.getString(MySharedPref.NATIVE_2))
                        mySharedPref.putString(MySharedPref.BANNER_1, mFirebaseRemoteConfig.getString(MySharedPref.BANNER_1))
                        mySharedPref.putString(MySharedPref.BANNER_2, mFirebaseRemoteConfig.getString(MySharedPref.BANNER_2))
                        mySharedPref.putString(MySharedPref.REWARD_1, mFirebaseRemoteConfig.getString(MySharedPref.REWARD_1))
                        mySharedPref.putString(MySharedPref.REWARD_2, mFirebaseRemoteConfig.getString(MySharedPref.REWARD_2))
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
                            mySharedPref.putInt(MySharedPref.AD_COUNT, 0)
                        }

                        Log.e("***Valueis", "saved value " + mySharedPref.getString(MySharedPref.BANNER_2))


                        mFirebaseRemoteConfig.fetchAndActivate()
                    } else {
                        //Toast.makeText(context, "Fetch Failed", Toast.LENGTH_SHORT).show()
                    }
                    // Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show()
                }
            })
    }

    fun getBannerID(context: Activity): String {
        var mainId = ""
        val allIds = ArrayList<String>()
        try{
            val mySharedPref = MySharedPref(context)
            if (isDebugRuning) {
                return "ca-app-pub-3940256099942544/6300978111" // test id
            }
            var id :String? = mySharedPref.getString(MySharedPref.BANNER_1)
            if(!id.isNullOrBlank())
                allIds.add(id)
            id  = mySharedPref.getString(MySharedPref.BANNER_2)
            if(!id.isNullOrBlank())
                allIds.add(id)
            if(allIds.size > 0){
                bannerCounter += 1
                if(bannerCounter >= allIds.size){
                    bannerCounter = 0
                }
                mainId = allIds.get(bannerCounter)
            }
        }catch (e : Exception){
            e.printStackTrace()
            try{
                if(allIds.size > 0){
                    if(!allIds[0].isNullOrBlank())
                        mainId = allIds[0]
                }
            }catch (ee : Exception){
                ee.printStackTrace()
                mainId = ""
            }
        }
        return mainId
    }

    fun getInterstialId(context: Activity): String {
        var mainId = ""
        val allIds = ArrayList<String>()
        try{
            if (isDebugRuning) {
                return "ca-app-pub-3940256099942544/1033173712" // test id
            }
            val mySharedPref = MySharedPref(context)
            var id :String? = mySharedPref.getString(MySharedPref.INTERSTITIAL_1)
            if(!id.isNullOrBlank())
                allIds.add(id)
            id  = mySharedPref.getString(MySharedPref.INTERSTITIAL_2)
            if(!id.isNullOrBlank())
                allIds.add(id)
            id  = mySharedPref.getString(MySharedPref.INTERSTITIAL_3)
            if(!id.isNullOrBlank())
                allIds.add(id)
            id  = mySharedPref.getString(MySharedPref.INTERSTITIAL_4)
            if(!id.isNullOrBlank())
                allIds.add(id)
            if(allIds.size > 0){
                interstilCounter += 1
                if(interstilCounter >= allIds.size){
                    interstilCounter = 0
                }
                mainId = allIds.get(interstilCounter)
            }
        }catch (e : Exception){
            e.printStackTrace()
            try{
                if(allIds.size > 0){
                    if(!allIds[0].isNullOrBlank())
                        mainId = allIds[0]
                }
            }catch (ee : Exception){
                ee.printStackTrace()
                mainId = ""
            }
        }
        return mainId
    }

    fun getNativeId(context: Activity): String {
        var mainId = ""
        val allIds = ArrayList<String>()
        try{
            val mySharedPref = MySharedPref(context)
            if (isDebugRuning) {
                return "ca-app-pub-3940256099942544/2247696110" // test id
            }
            var id :String? = mySharedPref.getString(MySharedPref.NATIVE_1)
            if(!id.isNullOrBlank())
                allIds.add(id)
            id  = mySharedPref.getString(MySharedPref.NATIVE_2)
            if(!id.isNullOrBlank())
                allIds.add(id)
            if(allIds.size > 0){
                nativeCounter += 1
                if(nativeCounter >= allIds.size){
                    nativeCounter = 0
                }
                mainId = allIds.get(nativeCounter)
            }
        }catch (e : Exception){
            e.printStackTrace()
            try{
                if(allIds.size > 0){
                    if(!allIds[0].isNullOrBlank())
                        mainId = allIds[0]
                }
            }catch (ee : Exception){
                ee.printStackTrace()
                mainId = ""
            }
        }
        return mainId
    }

//    val rewardedAd: String
//        get() {
//            var id = ""
//            id = if (isDebugRuning) {
//                "ca-app-pub-3940256099942544/5224354917" // test id
//            } else {
//                "ca-app-pub-6247650642874574/8098374846" // orignal id
//            }
//            return id
//        }

    fun gerewardedAdID(context: Activity): String {
        var mainId = ""
        val allIds = ArrayList<String>()
        try{
            val mySharedPref = MySharedPref(context)
            if (isDebugRuning) {
                return "ca-app-pub-3940256099942544/5224354917" // test id
            }
            var id :String? = mySharedPref.getString(MySharedPref.NATIVE_1)
            if(!id.isNullOrBlank())
                allIds.add(id)
            id  = mySharedPref.getString(MySharedPref.NATIVE_2)
            if(!id.isNullOrBlank())
                allIds.add(id)
            if(allIds.size > 0){
                nativeCounter += 1
                if(nativeCounter >= allIds.size){
                    nativeCounter = 0
                }
                mainId = allIds.get(nativeCounter)
            }
        }catch (e : Exception){
            e.printStackTrace()
            try{
                if(allIds.size > 0){
                    if(!allIds[0].isNullOrBlank())
                        mainId = allIds[0]
                }
            }catch (ee : Exception){
                ee.printStackTrace()
                mainId = ""
            }
        }
        return mainId
    }

    fun getOpenAppId(mySharedPref: MySharedPref ): String {
        if (isDebugRuning) {
            return "ca-app-pub-3940256099942544/3419835294" // test id
        }
        return mySharedPref.getString(MySharedPref.APP_OPEN)!!
    }
}


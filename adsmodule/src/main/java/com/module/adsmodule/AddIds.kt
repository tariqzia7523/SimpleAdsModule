package com.module.ads

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AddIds( var isDebugRuning : Boolean) {

    companion object {
        var bannerCounter = 1
        var interstilCounter = 1
        var nativeCounter = 1
    }

//    var isDebugRuning = true

    fun getAllids(context: Context) {
//        FirebaseApp.initializeApp(context)
//        val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
//        mFirebaseRemoteConfig.fetch(0)
//            .addOnCompleteListener(context, object : OnCompleteListener<Void?> {
//                override fun onComplete(task: Task<Void?>) {
//                    if (task.isSuccessful()) {
//                        // Toast.makeText(context, "Fetch Succeeded", Toast.LENGTH_SHORT).show()
//                        Log.e("***Valueis", " Fetch Succeeded ")
//                        // After config data is successfully fetched, it must be activated before newly fetched
//                        // values are returned.
//                        getAllValues(context,mFirebaseRemoteConfig)
//
//                    } else {
//                        //Toast.makeText(context, "Fetch Failed", Toast.LENGTH_SHORT).show()
//                    }
//                    // Toast.makeText(context, "Welcome", Toast.LENGTH_SHORT).show()
//                }
//            })
//        val mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
//        val configSettings =  FirebaseRemoteConfigSettings.Builder().build()
//        mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings).addOnCompleteListener {
//            if(it.isSuccessful){
//                getAllValues(context,mFirebaseRemoteConfig)
//            }
//        }

        FirebaseDatabase.getInstance().getReference("DATA")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    try{
                        getAllValues(context,snapshot)
                    }catch (e : Exception){
                        e.printStackTrace()
                    }
                }
                override fun onCancelled(error: DatabaseError) {

                }
            })
    }

    private fun getAllValues(context: Context, snapshot : DataSnapshot) {
        val mySharedPref = MySharedPref(context)
        try{
            mySharedPref.putString(
                MySharedPref.APP_OPEN,
                snapshot.child(MySharedPref.APP_OPEN).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.APP_OPEN,"")
        }
        try{
            mySharedPref.putString(
                MySharedPref.INTERSTITIAL_1,
                snapshot.child(MySharedPref.INTERSTITIAL_1).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.INTERSTITIAL_1,"")
        }
        try{
            mySharedPref.putString(
                MySharedPref.INTERSTITIAL_2,
                snapshot.child(MySharedPref.INTERSTITIAL_2).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.INTERSTITIAL_2,"")
        }
        try{
            mySharedPref.putString(
                MySharedPref.INTERSTITIAL_3,
                snapshot.child(MySharedPref.INTERSTITIAL_3).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.INTERSTITIAL_3,"")
        }
        try{
            mySharedPref.putString(
                MySharedPref.INTERSTITIAL_4,
                snapshot.child(MySharedPref.INTERSTITIAL_4).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.INTERSTITIAL_4,"")
        }
        try{
            mySharedPref.putString(
                MySharedPref.BANNER_1,
                snapshot.child(MySharedPref.BANNER_1).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.BANNER_1,"")
        }

        try{
            mySharedPref.putString(
                MySharedPref.BANNER_2,
                snapshot.child(MySharedPref.BANNER_2).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.BANNER_2,"")
        }

        try{
            mySharedPref.putString(
                MySharedPref.NATIVE_1,
                snapshot.child(MySharedPref.NATIVE_1).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.NATIVE_1,"")
        }

        try{
            mySharedPref.putString(
                MySharedPref.NATIVE_2,
                snapshot.child(MySharedPref.NATIVE_2).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.NATIVE_2,"")
        }

        try{
            mySharedPref.putString(
                MySharedPref.REWARD_1,
                snapshot.child(MySharedPref.REWARD_1).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.REWARD_1,"")
        }
        try{
            mySharedPref.putString(
                MySharedPref.REWARD_2,
                snapshot.child(MySharedPref.REWARD_2).getValue(String::class.java)!!.trim())
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putString(MySharedPref.REWARD_2,"")
        }

        try{
            mySharedPref.putBoolen(
                MySharedPref.APP_OPEN_CALL,
                snapshot.child(MySharedPref.APP_OPEN_CALL).getValue(Boolean::class.java)!!)
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putBoolen(MySharedPref.APP_OPEN_CALL,true)
        }

        try{
            mySharedPref.putBoolen(
                MySharedPref.BANNER_CALL,
                snapshot.child(MySharedPref.BANNER_CALL).getValue(Boolean::class.java)!!)
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putBoolen(MySharedPref.BANNER_CALL,true)
        }

        try{
            mySharedPref.putBoolen(
                MySharedPref.INTER_CALL,
                snapshot.child(MySharedPref.INTER_CALL).getValue(Boolean::class.java)!!)
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putBoolen(MySharedPref.INTER_CALL,true)
        }


        try{
            mySharedPref.putBoolen(
                MySharedPref.NATIVE_CALL,
                snapshot.child(MySharedPref.NATIVE_CALL).getValue(Boolean::class.java)!!)
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putBoolen(MySharedPref.NATIVE_CALL,true)
        }


        try{
            mySharedPref.putBoolen(
                MySharedPref.REWARD_CALL,
                snapshot.child(MySharedPref.REWARD_CALL).getValue(Boolean::class.java)!!)
        }catch (e : Exception){
            e.printStackTrace()
            mySharedPref.putBoolen(MySharedPref.REWARD_CALL,true)
        }

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
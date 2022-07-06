package com.module.ads

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.module.adsmodule.R


class MySharedPref(var context: Context) {

    companion object{
        val APP_OPEN = "app_open"
        val BANNER_1 = "banner_1"
        val BANNER_2 = "banner_2"
        val INTERSTITIAL_1 = "interstitial_1"
        val INTERSTITIAL_2 = "interstitial_2"
        val INTERSTITIAL_3 = "interstitial_3"
        val INTERSTITIAL_4 = "interstitial_4"
        val NATIVE_1 = "native_1"
        val NATIVE_2 = "native_2"
        val REWARD_1 = "reward_1"
        val REWARD_2 = "reward_2"
        val AD_COUNT = "ad_count"

        val BANNER_CALL = "banner_call"
        val INTER_CALL = "interstitial_call"
        val NATIVE_CALL = "native_call"
        val APP_OPEN_CALL = "app_open_call"
        val REWARD_CALL = "reward_call"
    }

    var sharedPreferences: SharedPreferences
    fun setPurcheshed(value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(context.getString(R.string.is_purchsed), value).apply()
    }

    val isPurshed: Boolean
        get() = sharedPreferences.getBoolean(context.getString(R.string.is_purchsed), false)
    var isUserReviwed: Boolean
        get() = sharedPreferences.getBoolean(context.getString(R.string.user_reviwed), false)
        set(value) {
            val editor = sharedPreferences.edit()
            editor.putBoolean(context.getString(R.string.user_reviwed), value).apply()
        }
    val userReview: Boolean
        get() = !isUserReviwed && appCount > 2
    var userIntro: Boolean
        get() = sharedPreferences.getBoolean(context.getString(R.string.user_intro), false)
        set(value) {
            val editor = sharedPreferences.edit()
            editor.putBoolean(context.getString(R.string.user_intro), value).apply()
        }
    var appCount: Int
        get() = sharedPreferences.getInt(context.getString(R.string.app_count), 0)
        set(value) {
            val editor = sharedPreferences.edit()
            editor.putInt(context.getString(R.string.app_count), value).apply()
        }
    var privacyAccepted: Boolean
        get() = sharedPreferences.getBoolean(context.getString(R.string.privacy_accepted), false)
        set(value) {
            val editor = sharedPreferences.edit()
            editor.putBoolean(context.getString(R.string.privacy_accepted), value).apply()
        }

    var rewaredVideoCout: Int
        get() = sharedPreferences.getInt(context.getString(R.string.rewarded_video_add_count), 3)
        set(value) {
            val editor = sharedPreferences.edit()
            editor.putInt(context.getString(R.string.rewarded_video_add_count), value).apply()
        }

    var rewaredVideocurrentCount: Int
        get() = sharedPreferences.getInt(
            context.getString(R.string.rewarded_video_add_count_cuurent),
            0
        )
        set(value) {
            val editor = sharedPreferences.edit()
            editor.putInt(context.getString(R.string.rewarded_video_add_count_cuurent), value)
                .apply()
        }


    fun putString(key: String?, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
        Log.e("***AdIds", "key $key value $value")
    }

    fun getString(key: String?): String? {
        return sharedPreferences.getString(key, "")
    }

    fun putBoolen(key: String?, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
        Log.e("***AdIds", "key $key value $value")
    }

    fun getBoolen(key: String?): Boolean {
        return sharedPreferences.getBoolean(key, true)
    }

    fun putInt(key: String?, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
        Log.e("***AdIds", "key $key value $value")
    }

    fun getInt(key: String): Int {
        return sharedPreferences.getInt(key, 0)
    }

    init {
        sharedPreferences =
            context.getSharedPreferences(context.getString(R.string.my_pref), Context.MODE_PRIVATE)
    }
}
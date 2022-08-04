package com.module.newsampleads

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.module.ads.AddIds
import com.module.newsampleads.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        AddIds(BuildConfig.DEBUG).getAllids(this)
        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity,MainActivity::class.java))
        }, 2000)
    }
}
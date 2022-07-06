package com.module.newsampleads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.module.ads.AddIds

import com.module.ads.AddInitilizer

class MainActivity : AppCompatActivity() {
    lateinit var addInitilizer: AddInitilizer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Call in splash to get all ids from firebase
        AddIds(false).getAllids(this)


        // you can pass true of false
        //true for debug and true to running release

        addInitilizer = AddInitilizer(applicationContext,this, false){
            // on add close call back will run in this fun


            val tag = it // this is the tag passed while displaying ad calling
            // now place checks and use it for further call


        }

        //by passing interface will start loading interstitial ad
        // or pass null if interstitial ad is not required for the activity
        // addInitilizer = AddInitilizer(applicationContext,this,null)


        //loading banner
        addInitilizer.loadBanner(findViewById(R.id.banner_container))

        // pass three paramenters for loading asnd displaying native add templateView, placeholder text, and ad container
        addInitilizer.loadNativeAdd(findViewById(R.id.nativeTemplateView),findViewById(R.id.temp_add_text),findViewById(R.id.add_container))

        // or if add loading is required,that will be displayed later then call
        //addInitilizer.loadNativeAdd(null,null,null)
        //for displaying native add call
        //addInitilizer.setnativeAddOnView(findViewById(R.id.nativeTemplateView))

        findViewById<View>(R.id.show_intestial).setOnClickListener {
            if(!addInitilizer.showInterstailAdd("Any tag")){
                // TODO actual task
            }
        }

    }
}
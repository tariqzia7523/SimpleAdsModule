# SimpleAdsModule
 This project contains library for easy implementation of ad mob according to ad policies. Moreover ad ids are to be set using remort config (so connect your project to firebase first) These ids will be called only on release, use following keys in remort config firebase , and values are string
 
 app_open
 banner_1
 banner_2
 interstitial_1
 interstitial_2
 interstitial_1
 interstitial_2
 interstitial_3
 interstitial_4
 native_1
 native_2
 reward_1
 reward_2
 
 //Following key is Int refers as ad counter which means that interstiall add to be called after how many clicks.
 ad_count
 
 to call or block any type of add use following keys by default all ads are open to be called. values are boolean
 
 banner_call
 interstitial_call
 native_call
 app_open_call
 reward_call
 
 # implementation 
 Add flowing in 
  maven { url 'https://jitpack.io' }
  
  then following line in app gradle
  
 implementation 'com.github.tariqzia7523:SimpleAdsModule:1.0.1'

# Usage 

call following code in splash

 AddIds(BuildConfig.DEBUG).getAllids(this)
 
you can refer to MainActivity in sample project

make a global variable 

  
  addInitilizer = AddInitilizer(applicationContext,this, BuildConfig.DEBUG){
       val tag = it // this is the tag passed while displaying ad calling
       // now place checks and use it for further call
  }


  //by passing interface will start loading interstitial ad
  // or pass null if interstitial ad is not required for the activity
  // addInitilizer = AddInitilizer(applicationContext,this,null)

   loading banner
   addInitilizer.loadBanner(findViewById(R.id.banner_container))

   loading native
  addInitilizer.loadNativeAdd(findViewById(R.id.nativeTemplateView),findViewById(R.id.temp_add_text),findViewById(R.id.add_container))
   
   or if add loading is required,that will be displayed later then call
   addInitilizer.loadNativeAdd(null,null,null)

   findViewById<View>(R.id.show_intestial).setOnClickListener {
          if(!addInitilizer.showInterstailAdd("Any tag")){
              // TODO actual task
          }
   }


   use following code in layouts
   <RelativeLayout
       android:id="@+id/add_container"
       android:layout_width="match_parent"
       android:layout_height="wrap_content"
       android:layout_alignParentBottom="true"
       android:layout_marginLeft="@dimen/_10sdp"
       android:layout_marginTop="@dimen/_10sdp"
       android:layout_marginRight="@dimen/_10sdp"
       android:background="@drawable/gnt_outline_shape"
       android:minHeight="@dimen/_130sdp">
       <com.module.adsmodule.TemplateView
            android:id="@+id/nativeTemplateView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:visibility="gone"
            app:gnt_template_type="@layout/gnt_small_template_view" />
            app:gnt_template_type="@layout/gnt_medium_template_view"
       <TextView
            android:id="@+id/temp_add_text"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerInParent="true"
            android:text="@string/ad_will_display_hare" />
    </RelativeLayout>

you can use 
app:gnt_template_type="@layout/gnt_small_template_view" or app:gnt_template_type="@layout/gnt_medium_template_view"

you can also use TemplateView sepratly


 <com.module.ads.TemplateView
   android:id="@+id/nativeTemplateView"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:visibility="gone"
    android:background="@drawable/gnt_outline_shape"
    app:gnt_template_type="@layout/gnt_medium_template_view"/>
            

to add open app add following line of code in Application class oncreate method
val appOpenManager = AppOpenManager(this, MySharedPref(this), BuildConfig.DEBUG)


# InApp purcheses
project has in app purcheses to remove ad calls use following method.
addInitilizer.goAddFree()



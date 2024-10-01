package com.blackpuppydev.matchy_native.activity

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.blackpuppydev.matchy_native.AppPreference
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.database.UserDatabase
import com.blackpuppydev.matchy_native.database.dao.UserDao
import com.blackpuppydev.matchy_native.listener.PermissionCallback
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

open class BaseActivity : AppCompatActivity() {

    var permissionCallback:PermissionCallback? = null
    var dao: UserDao? = null
    private val channelId = "channel01"


    companion object {
        const val CAMERA_PERMISSION_CODE = 101
        const val EXTERNAL_PERMISSION_CODE = 102
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        getUserDatabase()

    }

    @JvmName("setPermissionCallback1")
    fun setPermissionCallback(permissionCallback:PermissionCallback){
        this.permissionCallback = permissionCallback
    }


    fun checkNetwork(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        return connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)!!
            .state == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)!!.state == NetworkInfo.State.CONNECTED
    }

    fun checkPermission(permission: String, requestCode: Int):Boolean {
        Log.e("BaseActivity : ","checkPermission")
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,arrayOf(permission), requestCode)
        } else {
            return true
        }
        return false
    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>,
                                            grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == CAMERA_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permissionCallback?.permissionGranted("camera",true)
            } else {
                permissionCallback?.permissionGranted("camera",false)
            }
        } else if (requestCode == EXTERNAL_PERMISSION_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                permissionCallback?.permissionGranted("storage",true)
            } else {
                permissionCallback?.permissionGranted("storage",false)
            }
        }
    }


    fun setBaseLanguage(languageCode:String){
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
    }


    private fun getUserDatabase(){
        dao = UserDatabase.getUserDatabase(this).userDao()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        System.gc()
        System.runFinalization()
        Runtime.getRuntime().gc()

    }

    fun replaceFragment(fragment: Fragment, isAppInit:Boolean = false){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (isAppInit) fragmentTransaction.add(R.id.content,fragment)
        else fragmentTransaction.replace(R.id.content,fragment)

        fragmentTransaction.commit()
    }

    private fun createNotificationChannel() {

        val name = "matchy app"
        val descriptionText = "matchy description"
        val importance = NotificationManager.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelId, name, importance).apply {
            description = descriptionText
        }

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    fun showNotification(content:String, title:String,intent:Intent){

        createNotificationChannel()

        val date = Date()
        val notificationId = SimpleDateFormat("ddHHmmss", Locale.US).format(date).toInt()
//       var intent = Intent(this,TargetClass::class.java)
//        put extra something intent
//        mainIntent.putExtra()
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val mainPendingIntent = PendingIntent.getActivity(this,1,intent,PendingIntent.FLAG_IMMUTABLE)

        val notificationBuilder = NotificationCompat.Builder(this,channelId)
        notificationBuilder.apply {
//            setSmallIcon()
            setContentTitle(title)
            setContentText(content)
            priority = NotificationCompat.PRIORITY_DEFAULT
            setAutoCancel(true)
            setContentIntent(mainPendingIntent)
        }

        val notificationManagerCompat = NotificationManagerCompat.from(this)
        notificationManagerCompat.notify(notificationId,notificationBuilder.build())
    }


    fun setLanguageApp(languageCode:String){

        val resource = this.resources
        val configuration = resource.configuration

        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        configuration.setLocale(locale)

        resource.updateConfiguration(configuration,resource.displayMetrics)

    }



//    fun enableNightMode(enable:Boolean){
//
//        if (enable) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
//
//        AppPreference.getInstance().setEnableNightMode(enable)
//
//    }
//
//
//    fun checkNightMode() {
//
//        AppPreference.getInstance().setSharedPreference(this)
//
//        if(!AppPreference.getInstance().getEnableNightMode()) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//
//        } else {
//            if (AppPreference.getInstance().getEnableNightMode()){
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//            } else {
//                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//            }
//        }
//    }

}
package com.blackpuppydev.matchy_native.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.blackpuppydev.matchy_native.AppPreference
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.listener.PermissionCallback
import java.util.*
import kotlin.collections.ArrayList

open class BaseActivity : AppCompatActivity() {

    var permissionCallback:PermissionCallback? = null


    companion object{
        const val CAMERA_PERMISSION_CODE = 101
        const val EXTERNAL_PERMISSION_CODE = 102
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)






    }



    @JvmName("setPermissionCallback1")
    fun setPermissionCallback(permissionCallback:PermissionCallback){
        this.permissionCallback = permissionCallback
    }

    @SuppressLint("MissingPermission")
    public fun checkNetwork(): Boolean {
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


    fun startDataBase(){




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
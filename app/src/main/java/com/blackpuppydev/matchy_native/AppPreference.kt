package com.blackpuppydev.matchy_native

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import com.blackpuppydev.matchy_native.constance.Preference.APP_NAME
import com.blackpuppydev.matchy_native.constance.Preference.IMAGE
import com.blackpuppydev.matchy_native.constance.Preference.LANGUAGE
import com.blackpuppydev.matchy_native.constance.Preference.PASSWORD
import com.blackpuppydev.matchy_native.constance.Preference.USERNAME
import com.securepreferences.SecurePreferences
import java.io.ByteArrayOutputStream


class AppPreference {

    var sharedPreference: SharedPreferences? = null

    companion object{

        private var instance:AppPreference? = null

        fun getInstance():AppPreference {
            if(instance == null) instance = AppPreference()
            return instance!!
        }
    }


    fun setSharedPreference(context: Context){
        sharedPreference = SecurePreferences(context, "1234", APP_NAME)
    }

    fun setUsername(username:String){
        sharedPreference?.edit()?.putString(USERNAME,username)?.apply()
    }

    fun getUsername(): String? {
        return sharedPreference?.getString(USERNAME, "")
    }

    fun setPassword(password:String){
        sharedPreference?.edit()?.putString(PASSWORD,password)?.apply()
    }

    fun getPassword(): String? {
        return sharedPreference?.getString(PASSWORD, "")
    }

    fun setLanguage(language:String){
        sharedPreference?.edit()?.putString(LANGUAGE,language)?.apply()
    }

    fun getLanguage(): String? {
        return sharedPreference?.getString(LANGUAGE, "")
    }


    fun setImageProfile(bitmap:Bitmap){

        //convert image profile
        val byteArrayOutputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream)
        val byteArray: ByteArray = byteArrayOutputStream.toByteArray()

        val encodedImage: String = android.util.Base64.encodeToString(byteArray, android.util.Base64.DEFAULT)
        sharedPreference?.edit()?.putString(IMAGE, encodedImage)?.apply()


        //get bitmap imageview
//        val bm = (imageView.getDrawable() as BitmapDrawable).bitmap

        //set bitmap -> setImageBitmap(bitmap)


    }

//    fun getImageProfile():Bitmap?{
//        val previouslyEncodedImage = sharedPreference.getString(IMAGE, "")
//        val b: ByteArray = android.util.Base64.decode(previouslyEncodedImage, android.util.Base64.DEFAULT)
//        return BitmapFactory.decodeByteArray(b, 0, b.size)
//    }

    fun setImageProfile(uri:Uri){
        sharedPreference?.edit()?.putString(IMAGE, uri.toString())?.apply()
    }

    fun getImageProfile():Uri?{
        val image = sharedPreference?.getString(IMAGE, "")
        return Uri.parse(image)
    }

    fun setEnableNightMode(enable:Boolean){
        sharedPreference?.edit()?.putBoolean("NightMode",enable)?.apply()
    }

    fun getEnableNightMode():Boolean{
        return sharedPreference?.getBoolean("NightMode",false)!!
    }


}
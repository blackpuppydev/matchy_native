package com.blackpuppydev.matchy_native.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import com.blackpuppydev.matchy_native.AppPreference
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.databinding.ActivitySplashBinding
import com.blackpuppydev.matchy_native.dialog.BaseDialog


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private var binding:ActivitySplashBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        AppPreference.getInstance().setSharedPreference(applicationContext)
    }

    override fun onResume() {
        super.onResume()

        object : CountDownTimer(2000,1000){

            override fun onTick(p0: Long) {}

            override fun onFinish() {

                if (!checkNetwork()){
                    object : BaseDialog(this@SplashActivity){
                        override fun onCancelClick() {
                            dismiss()
                            finishAndRemoveTask()
                        }
                    }.show("กรุณาเชื่อมต่ออินเทอร์เน็ต และลองใหม่อีกครั้ง")
                } else {
                    checkPermission(Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)
                    checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE,GALLERY_PERMISSION_CODE)

                    if (AppPreference.getInstance().getLanguage().isNullOrEmpty()) setBaseLanguage("th-TH")
                    else setBaseLanguage(AppPreference.getInstance().getLanguage().toString())

//                    if (AppPreference.getInstance().getUsername().isNullOrEmpty()){
//                        startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
//                    } else {
                        startActivity(Intent(this@SplashActivity,MainActivity::class.java))
//                    }
                }
            }
        }.start()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }




}
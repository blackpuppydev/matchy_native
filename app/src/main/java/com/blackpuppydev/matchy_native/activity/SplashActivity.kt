package com.blackpuppydev.matchy_native.activity

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import com.blackpuppydev.matchy_native.AppPreference
import com.blackpuppydev.matchy_native.databinding.ActivitySplashBinding
import com.blackpuppydev.matchy_native.dialog.StandardDialog
import com.blackpuppydev.matchy_native.listener.PermissionCallback


@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {

    private var binding:ActivitySplashBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setPermissionCallback(object : PermissionCallback{
            override fun permissionGranted(type: String, granted: Boolean) {
//                if (type == "storage" && granted) goToMain()
//                else finish()
                goToMain()
            }

        })


//        checkNightMode()

        AppPreference.getInstance().setSharedPreference(applicationContext)
    }

    override fun onResume() {
        super.onResume()

        object : CountDownTimer(2000,1000){

            override fun onTick(p0: Long) {}

            override fun onFinish() {

                if (!checkNetwork()){
                    object : StandardDialog(this@SplashActivity){
                        override fun onCancelClick() {
                            dismiss()
                            finishAndRemoveTask()
                        }
                    }.show("กรุณาเชื่อมต่ออินเทอร์เน็ต และลองใหม่อีกครั้ง")
                } else {

                    if(checkPermission(Manifest.permission.READ_EXTERNAL_STORAGE, EXTERNAL_PERMISSION_CODE)) goToMain()


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

    fun goToMain(){

        if (AppPreference.getInstance().getLanguage().isNullOrEmpty()) setBaseLanguage("th-TH")
        else setBaseLanguage(AppPreference.getInstance().getLanguage().toString())

//                    if (AppPreference.getInstance().getUsername().isNullOrEmpty()){
//                        startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
//                    } else {
        startActivity(Intent(this@SplashActivity,LoginActivity::class.java))
//                    }
    }



}
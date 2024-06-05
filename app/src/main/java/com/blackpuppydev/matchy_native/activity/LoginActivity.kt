package com.blackpuppydev.matchy_native.activity

import android.content.Intent
import android.os.Bundle
import com.blackpuppydev.matchy_native.AppPreference
import com.blackpuppydev.matchy_native.api.ApiManager
import com.blackpuppydev.matchy_native.api.UserApi
import com.blackpuppydev.matchy_native.api.response.UserResponse
import com.blackpuppydev.matchy_native.databinding.ActivityLoginBinding
import com.blackpuppydev.matchy_native.dialog.BaseDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : BaseActivity() {


    private var binding:ActivityLoginBinding? = null
    var appPreference:AppPreference = AppPreference.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        appPreference.setSharedPreference(this)


        binding?.apply {

            btnLogin.setOnClickListener {
                if (binding?.editId?.text.toString().isEmpty() ||
                    binding?.editPassword?.text.toString().isEmpty()){

                    object : BaseDialog(this@LoginActivity) {
                        override fun onCancelClick() {
                            dismiss()
                        }
                    }.show("please add username and password")
                } else {
                    if(checkLogin(binding?.editId?.text.toString(),binding?.editPassword?.text.toString())){

                        //save share pref
                        appPreference.setUsername(binding?.editId?.text.toString())
                        appPreference.setPassword(binding?.editPassword?.text.toString())

                        //start to main
                        if(appPreference.getImageProfile() == null){
                            startActivity(Intent(this@LoginActivity,FirstTimeActivity::class.java))
                        } else {
                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        }

                    } else {
                        object : BaseDialog(this@LoginActivity){
                            override fun onCancelClick() {
                                dismiss()
                            }
                        }.show("username or password is not correct")
                    }
                }


            }

            btnSignup.setOnClickListener {
                //startActivity(Intent(this,RegisterActivity::class.java))

                //for mock
                startActivity(Intent(this@LoginActivity,FirstTimeActivity::class.java))

            }

            btnForgot.setOnClickListener {


            }

        }

//        binding?.btnLogin?.setOnClickListener {
//
//
//
//
//        }
//
//        binding?.btnSignup?.setOnClickListener {
////            startActivity(Intent(this,RegisterActivity::class.java))
//
//            //for mock
//            startActivity(Intent(this,FirstTimeActivity::class.java))
//        }


//        //forgot
//        binding?.btnForgot?.setOnClickListener {
//
//        }




    }




    private fun checkLogin(username:String, password:String):Boolean {

        var successLogin = false

        ApiManager.getRetrofit().create(UserApi::class.java).getUserWithUsername(username).enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                if (response?.body()?.password == password)
                    successLogin = true
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                successLogin = false
            }
        })

        return successLogin

    }
}
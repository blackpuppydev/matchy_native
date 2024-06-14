package com.blackpuppydev.matchy_native.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.blackpuppydev.matchy_native.database.AppDatabase
import com.blackpuppydev.matchy_native.database.entity.UserEntity
import com.blackpuppydev.matchy_native.databinding.ActivityLoginBinding
import com.blackpuppydev.matchy_native.viewmodel.LoginViewModel

class LoginActivity : BaseActivity() {


    private var binding:ActivityLoginBinding? = null

    private var viewModel:LoginViewModel? = null
//    lateinit var appDatabase:AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

//        appDatabase = AppDatabase.getAppDatabase(this@LoginActivity)

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

        binding?.apply {

            btnLogin.setOnClickListener {
                if (binding?.editId?.text.toString().isEmpty() || binding?.editPassword?.text.toString().isEmpty()){

                    viewModel!!.getErrorDialog(this@LoginActivity,"please add username and password")

//                    object : StandardDialog(this@LoginActivity) {
//                        override fun onCancelClick() {
//                            dismiss()
//                        }
//                    }.show("please add username and password")


                } else {
                    viewModel!!.checkLogin(binding?.editId?.text.toString(),binding?.editPassword?.text.toString())

                    if (viewModel!!.loginSuccess) {

//                        appDatabase.userDao().insertUser(UserEntity.UsersEntity(123,123,"","","",""))


                        viewModel!!.setUserPreference(this@LoginActivity,binding?.editId?.text.toString(),binding?.editPassword?.text.toString())


                        //start to main
                        if(viewModel!!.appPreference.getImageProfile() == null){
                            startActivity(Intent(this@LoginActivity,FirstTimeActivity::class.java))
                        } else {
                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        }

                    } else {

                        viewModel!!.getErrorDialog(this@LoginActivity,"username or password is not correct")


//                        object : StandardDialog(this@LoginActivity) {
//                            override fun onCancelClick() {
//                                dismiss()
//                            }
//                        }.show("username or password is not correct")
                    }


//                    if(checkLogin(binding?.editId?.text.toString(),binding?.editPassword?.text.toString())){
//
//                        //save share pref
//                        appPreference.setUsername(binding?.editId?.text.toString())
//                        appPreference.setPassword(binding?.editPassword?.text.toString())
//
//                        //start to main
//                        if(appPreference.getImageProfile() == null){
//                            startActivity(Intent(this@LoginActivity,FirstTimeActivity::class.java))
//                        } else {
//                            startActivity(Intent(this@LoginActivity,MainActivity::class.java))
//                        }
//
//                    } else {
//                        object : StandardDialog(this@LoginActivity){
//                            override fun onCancelClick() {
//                                dismiss()
//                            }
//                        }.show("username or password is not correct")
//                    }


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

}
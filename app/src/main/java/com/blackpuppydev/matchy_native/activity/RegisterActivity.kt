package com.blackpuppydev.matchy_native.activity

import android.os.Bundle
import com.blackpuppydev.matchy_native.databinding.ActivityRegisterBinding

class RegisterActivity : BaseActivity() {

    private var binding:ActivityRegisterBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnExit?.setOnClickListener {
            finish()
        }

        binding?.btnSignup?.setOnClickListener {

        }


    }


    fun checkExistPassword(password:String,repeat:String) : Boolean {
        return password == repeat
    }


}
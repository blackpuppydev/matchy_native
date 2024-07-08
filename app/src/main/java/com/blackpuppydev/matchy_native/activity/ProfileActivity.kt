package com.blackpuppydev.matchy_native.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    lateinit var binding:ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }
}
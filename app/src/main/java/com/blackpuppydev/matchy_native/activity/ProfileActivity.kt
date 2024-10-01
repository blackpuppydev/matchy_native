package com.blackpuppydev.matchy_native.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.blackpuppydev.matchy_native.databinding.ActivityProfileBinding
import com.blackpuppydev.matchy_native.fragment.main.ProfileFragment
import com.blackpuppydev.matchy_native.viewmodel.ProfileViewModel

class ProfileActivity : BaseActivity() {

    lateinit var binding:ActivityProfileBinding
    lateinit var viewModel:ProfileViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[ProfileViewModel::class.java]
        viewModel.getProfile()


        binding.apply {

            viewModel.detailProfile.observe(this@ProfileActivity){ profile ->
                nameProfile.text = "${profile.name} ${profile.lastName}"
            }

            btnEdit.setOnClickListener {
                replaceFragment(ProfileFragment.newInstance(viewModel.detailProfile.value!!))
            }

        }



    }

    override fun onResume() {
        super.onResume()



    }




}
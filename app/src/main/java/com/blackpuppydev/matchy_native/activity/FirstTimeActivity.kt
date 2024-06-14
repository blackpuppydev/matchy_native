package com.blackpuppydev.matchy_native.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.constance.LandingPage
import com.blackpuppydev.matchy_native.databinding.ActivityFirstTimeBinding
import com.blackpuppydev.matchy_native.fragment.first.ImageProfileFragment
import com.blackpuppydev.matchy_native.fragment.first.WearProfileFragment
import com.blackpuppydev.matchy_native.listener.FragmentEvent

class FirstTimeActivity : BaseActivity(),FragmentEvent {


    private var binding:ActivityFirstTimeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstTimeBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        replaceFragment(ImageProfileFragment.newInstance(),true)
//        replaceFragment(ImageProfileFragment.newInstance())



    }


    private fun replaceFragment(fragment: Fragment, isAppInit:Boolean = false){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (isAppInit) fragmentTransaction.add(R.id.content,fragment)
        else fragmentTransaction.replace(R.id.content,fragment)

        fragmentTransaction.commit()
    }


    override fun onSuccess() {

    }

    override fun onResult(result: String, type: String, landingPage: String) {

        when(type){
            "wear" -> ""


        }



        when (landingPage) {
            LandingPage.PAGE_IMAGE -> replaceFragment(ImageProfileFragment.newInstance())
            LandingPage.PAGE_WEAR -> replaceFragment(WearProfileFragment.newInstance())
        }
    }




}
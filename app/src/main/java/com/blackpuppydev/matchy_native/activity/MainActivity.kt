package com.blackpuppydev.matchy_native.activity

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.api.response.UserResponse
import com.blackpuppydev.matchy_native.constance.LandingPage
import com.blackpuppydev.matchy_native.databinding.ActivityMainBinding
import com.blackpuppydev.matchy_native.fragment.main.*
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent
import com.blackpuppydev.matchy_native.manager.Language

class MainActivity : BaseActivity() , MainFragmentEvent {


    private lateinit var binding:ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.e("MainActivity : ", "onCreate " + Language.getLanguage())

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.itemIconTintList = null

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.closet -> {
                    binding.btnIcon.visibility = View.GONE
                    binding.mainCloset.visibility = View.VISIBLE
                    binding.title.text = "Closet"
                    replaceFragment(ClosetFragment.newInstance())
                }

                R.id.discover -> {
                    showThreeButton()
                    binding.title.text = "Discover"
//                    replaceFragment(DiscoverFragment.newInstance(getTestDiscover()))
                    replaceFragment(DiscoverFragment.newInstance())




                }

                R.id.style -> {
                    showThreeButton()
                    binding.title.text = "Styling"
                    replaceFragment(StyleFragment.newInstance("",""))

                }

                R.id.commu -> {
                    showThreeButton()
                    binding.title.text = "Community"
                    replaceFragment(CommunityFragment.newInstance())


                }

                R.id.profile -> {
                    showThreeButton()
                    binding.title.text = "Profile"
                    val profileFragment = MeFragment.newInstance()
                    profileFragment.setProfile(UserResponse("","","","",""))
                    replaceFragment(profileFragment)



                }
            }

            true
        }

    }

    override fun onResume() {
        super.onResume()


        replaceFragment(DiscoverFragment.newInstance(),true)

        binding.btnIcon.visibility = View.VISIBLE
        binding.mainCloset.visibility = View.GONE

        binding.bottomNavigationView.selectedItemId = R.id.discover

    }


    private fun replaceFragment(fragment: Fragment, isAppInit:Boolean = false){

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        if (isAppInit) fragmentTransaction.add(R.id.content,fragment)
        else fragmentTransaction.replace(R.id.content,fragment)

        fragmentTransaction.commit()
    }


    private fun showThreeButton(){
        binding.btnIcon.visibility = View.VISIBLE
        binding.mainCloset.visibility = View.GONE
    }

    override fun onSuccess() {

    }

    override fun onResult(result: String, landingPage: String) {

        when (landingPage){

            LandingPage.PAGE_DISCOVER -> {

            }
        }



    }

    override fun setNightMode(enableNightMode: Boolean) {
//        enableNightMode(enableNightMode)
    }


}
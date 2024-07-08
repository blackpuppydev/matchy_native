package com.blackpuppydev.matchy_native.fragment.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.activity.SplashActivity
import com.blackpuppydev.matchy_native.api.response.UserResponse
import com.blackpuppydev.matchy_native.databinding.FragmentMeBinding
import com.blackpuppydev.matchy_native.dialog.LanguageDialog
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent
import com.blackpuppydev.matchy_native.manager.Language


class MeFragment : Fragment() {

    private lateinit var binding: FragmentMeBinding
    private lateinit var profileData:UserResponse
    private lateinit var listener: MainFragmentEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    fun setProfile(profileData:UserResponse){
        this.profileData = profileData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentMeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as MainFragmentEvent
        }
        catch (e: ClassCastException){ }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.switchMode.setOnToggledListener { _, isOn ->
            Log.d("MeFragment",isOn.toString())
            when(isOn){
                true -> {
                    listener.setNightMode(false)
                }
                false -> {
                    //dark
                    listener.setNightMode(true)
                }
            }

        }

        val icon = binding.iconLanguage

        binding.btnLanguage.setOnClickListener {
            object : LanguageDialog(requireContext()){
                override fun onSelectLanguages(languageCode: String) {
                    Language.setLanguageApp(languageCode,requireContext())
                    when (languageCode) {
                        "English" -> icon.setImageResource(R.drawable.us_flag)
                        "Thai" -> icon.setImageResource(R.drawable.th_flag)
                    }
                    dismiss()

                    //restart app
                    val restart = Intent(requireContext(),SplashActivity::class.java)
                    restart.apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    }
                    context.startActivity(restart)
                }
            }.show()
        }

        binding.btnProfile.setOnClickListener {

        }



    }

    companion object {
        @JvmStatic
        fun newInstance() =
            MeFragment().apply {
                arguments = Bundle().apply {}
            }

    }
}
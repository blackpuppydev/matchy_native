package com.blackpuppydev.matchy_native.fragment.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.api.response.UserResponse
import com.blackpuppydev.matchy_native.databinding.FragmentProfileBinding
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

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
        binding = FragmentProfileBinding.inflate(inflater, container, false)
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


        binding.switchMode.setOnToggledListener { toggleableView, isOn ->
            Log.d("ProfileFragment",isOn.toString())
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



    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {}
            }

    }
}
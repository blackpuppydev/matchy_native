package com.blackpuppydev.matchy_native.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackpuppydev.matchy_native.api.response.ProfileResponse
import com.blackpuppydev.matchy_native.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private var profile:ProfileResponse? = null
    private var binding:FragmentProfileBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            profile = it.getParcelable("profile")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }


    companion object {
        @JvmStatic
        fun newInstance(profile:ProfileResponse) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putParcelable("profile",profile)
                }
            }
    }
}
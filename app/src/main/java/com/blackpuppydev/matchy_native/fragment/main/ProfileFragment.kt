package com.blackpuppydev.matchy_native.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.api.response.UserResponse
import com.blackpuppydev.matchy_native.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    private lateinit var profileData:UserResponse

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


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




//        LabeledSwitch labeledSwitch = findViewById(R.id.switch);
//        labeledSwitch.setOnToggledListener(new OnToggledListener() {
//            @Override
//            public void onSwitched(LabeledSwitch labeledSwitch, boolean isOn) {
//                // Implement your switching logic here
//            }
//        });
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            ProfileFragment().apply {
                arguments = Bundle().apply {}
            }

    }
}
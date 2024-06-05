package com.blackpuppydev.matchy_native.fragment.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackpuppydev.matchy_native.databinding.FragmentStyleBinding


class SelectStyleFragment : Fragment() {

    private lateinit var binding:FragmentStyleBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStyleBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            SelectStyleFragment().apply {}
    }
}
package com.blackpuppydev.matchy_native.fragment.first

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.databinding.FragmentWearProfileBinding
import com.blackpuppydev.matchy_native.listener.FragmentEvent
import java.lang.ClassCastException


class WearProfileFragment : Fragment() {

    private lateinit var binding:FragmentWearProfileBinding
    private lateinit var listener: FragmentEvent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as FragmentEvent
        } catch (e: ClassCastException) { }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentWearProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.groupWear.setOnCheckedChangeListener { _, id ->
            when (id) {
                R.id.select_menwear -> {

                }
                R.id.select_womenwear -> {

                }
                R.id.select_bothwear -> {

                }
            }

        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WearProfileFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}
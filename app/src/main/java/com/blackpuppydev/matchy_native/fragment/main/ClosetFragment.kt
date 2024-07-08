package com.blackpuppydev.matchy_native.fragment.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.blackpuppydev.matchy_native.BuildConfig
import com.blackpuppydev.matchy_native.R
import com.blackpuppydev.matchy_native.adapter.ClosetAdapter
import com.blackpuppydev.matchy_native.api.response.ClosetResponse
import com.blackpuppydev.matchy_native.databinding.FragmentClosetBinding
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent
import com.blackpuppydev.matchy_native.viewmodel.ClosetViewModel


class ClosetFragment : Fragment() {

    private lateinit var binding:FragmentClosetBinding
    private lateinit var viewModel:ClosetViewModel

    lateinit var listener:MainFragmentEvent

    private var list_closet:ArrayList<ClosetResponse>? = null


    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as MainFragmentEvent
        }
        catch (e: ClassCastException){ }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this)[ClosetViewModel::class.java]
        viewModel.itemCloset.observe(this){
                list_closet = it
        }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentClosetBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCloset(BuildConfig.TEST_USERNAME)
        viewModel.itemCloset.observe(viewLifecycleOwner){
            list_closet = it

            binding.apply {
                listCloset.apply {
                    layoutManager = GridLayoutManager(context, 2)
                    adapter = object : ClosetAdapter(list_closet!!){
                        override fun onSelectItem(closet: ClosetResponse) {
                            Log.e("ClosetFragment : " , "selected -> " + closet.title)
                        }
                    }
                }
            }
        }







    }




    companion object {
        @JvmStatic
        fun newInstance() =
            ClosetFragment().apply {
                arguments = Bundle().apply {}
            }
    }
}
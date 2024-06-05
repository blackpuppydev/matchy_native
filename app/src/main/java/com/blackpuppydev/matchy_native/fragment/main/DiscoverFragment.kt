package com.blackpuppydev.matchy_native.fragment.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.blackpuppydev.matchy_native.adapter.DiscoverAdapter
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import com.blackpuppydev.matchy_native.databinding.FragmentDiscoverBinding
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent

private const val LIST_DISCOVER = "discover"

class DiscoverFragment : Fragment() {

    private var listDiscover: ArrayList<DiscoverResponse>? = null
    private lateinit var listener:MainFragmentEvent
    private lateinit var binding:FragmentDiscoverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            listDiscover = it.getSerializable(LIST_DISCOVER) as ArrayList<DiscoverResponse>
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            listener = context as MainFragmentEvent
        }
        catch (e: ClassCastException){ }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDiscoverBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.listDiscover.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = object : DiscoverAdapter(listDiscover){
                override fun onResult(result: DiscoverResponse) {
                    Log.d("listDiscover",result.name + " " + result.pairing)
                }
            }
        }
    }



    companion object {
        @JvmStatic
        fun newInstance(listDiscover: ArrayList<DiscoverResponse>) =
            DiscoverFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(LIST_DISCOVER, listDiscover)
                }
            }
    }






}
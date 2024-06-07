package com.blackpuppydev.matchy_native.fragment.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.blackpuppydev.matchy_native.adapter.DiscoverAdapter
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import com.blackpuppydev.matchy_native.databinding.FragmentDiscoverBinding
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent
import com.google.android.material.tabs.TabLayout

private const val LIST_DISCOVER = "discover"

class DiscoverFragment : Fragment() {

    private var list_discover: ArrayList<DiscoverResponse>? = null
    private lateinit var listener:MainFragmentEvent
    private lateinit var binding:FragmentDiscoverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            list_discover = it.getSerializable(LIST_DISCOVER) as ArrayList<DiscoverResponse>
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

        binding.apply {

            listDiscover.apply {
                layoutManager = GridLayoutManager(context, 2)
                adapter = object : DiscoverAdapter(list_discover!!,"pairing"){
                    override fun onResult(result: DiscoverResponse) {
                        Log.d("listDiscover",result.name + " " + result.pairing)
                    }
                }
            }

            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

                override fun onTabSelected(tab: TabLayout.Tab?) {
                    val position = tab!!.position
                    var page = ""

                    when (position) {
                        //pairing
                        0 -> page = "pairing"
                        //popular
                        1 -> {
                            page = "popular"
                            list_discover = getSortFollower(list_discover!!)
                        }
                        //need help
                        2 -> page = "need help"
                    }

                    listDiscover.adapter = object : DiscoverAdapter(list_discover!!,page){
                        override fun onResult(result: DiscoverResponse) {
                            Log.d("listDiscover",result.name + " " + result.pairing)
                        }
                    }


                    Log.d("tab position select : " , position.toString())

                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            })
        }

    }



    companion object {
        @JvmStatic
        fun newInstance(list_discover: ArrayList<DiscoverResponse>) =
            DiscoverFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(LIST_DISCOVER, list_discover)
                }
            }
    }


    fun getSortFollower(list_discover:ArrayList<DiscoverResponse>) : ArrayList<DiscoverResponse>?{
        val sortFollower = list_discover.sortedBy{ it.follower }
        Log.d("getSortFollower : ", sortFollower[0].follower.toString())
        return sortFollower as ArrayList<DiscoverResponse>?
    }






}
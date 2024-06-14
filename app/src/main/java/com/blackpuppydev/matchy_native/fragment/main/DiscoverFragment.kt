package com.blackpuppydev.matchy_native.fragment.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.blackpuppydev.matchy_native.adapter.DiscoverAdapter
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import com.blackpuppydev.matchy_native.constance.LandingPage
import com.blackpuppydev.matchy_native.databinding.FragmentDiscoverBinding
import com.blackpuppydev.matchy_native.listener.MainFragmentEvent
import com.blackpuppydev.matchy_native.viewmodel.DiscoverViewModel
import com.google.android.material.tabs.TabLayout



class DiscoverFragment : Fragment() {

    private var list_discover: ArrayList<DiscoverResponse>? = null
    private lateinit var listener:MainFragmentEvent
    private lateinit var binding:FragmentDiscoverBinding


    private lateinit var disCoverViewModel:DiscoverViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        disCoverViewModel = ViewModelProvider(this)[DiscoverViewModel::class.java]

        disCoverViewModel.discoverData.observe(this){
            list_discover = it
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

        disCoverViewModel.getDataDiscover()
        disCoverViewModel.discoverData.observe(viewLifecycleOwner){

            list_discover = it

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
                            0 -> page = LandingPage.DIS_PAIRING
                            1 -> page = LandingPage.DIS_POPULAR
                            2 -> page = LandingPage.DIS_NEED
                        }

                        list_discover = getSortItem(list_discover!!,page)?.let { ArrayList(it) }

                        listDiscover.adapter = object : DiscoverAdapter(list_discover!!,page){
                            override fun onResult(result: DiscoverResponse) {
                                Log.d("listDiscover",result.name + " " + result.pairing)
                            }
                        }
                    }

                    override fun onTabUnselected(tab: TabLayout.Tab?) {

                    }

                    override fun onTabReselected(tab: TabLayout.Tab?) {

                    }

                })
            }
        }


    }



    companion object {
//        @JvmStatic
//        fun newInstance(list_discover: ArrayList<DiscoverResponse>) =
//            DiscoverFragment().apply {
//                arguments = Bundle().apply {
//                    putSerializable(LIST_DISCOVER, list_discover)
//                }
//            }

        @JvmStatic
        fun newInstance() = DiscoverFragment()
    }


    fun getSortItem(list_discover:ArrayList<DiscoverResponse>,type:String) : List<DiscoverResponse>?{
        var sortFollower:List<DiscoverResponse>? = null
        when (type) {
            LandingPage.DIS_PAIRING ->  sortFollower = list_discover.sortedBy{ it.pairing }
            LandingPage.DIS_POPULAR ->  sortFollower = list_discover.sortedByDescending{ it.follower }
            LandingPage.DIS_NEED -> sortFollower = list_discover.sortedByDescending{ it.activity }
        }
        return sortFollower
    }









}
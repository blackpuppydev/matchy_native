package com.blackpuppydev.matchy_native.api.repository

import com.blackpuppydev.matchy_native.api.ApiManager
import com.blackpuppydev.matchy_native.api.MainFragmentApi
import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverRepository {


    companion object {

        private var instance: DiscoverRepository? = null
        fun newInstance(): DiscoverRepository {
            if (instance == null) instance = DiscoverRepository()
            return instance!!
        }

    }


    fun getDiscover(username:String,callback: (discover:ArrayList<DiscoverResponse>) -> Unit){

        ApiManager.getRetrofit().create(MainFragmentApi::class.java).getDataDiscover(username).enqueue(object :
            Callback<ArrayList<DiscoverResponse>> {
            override fun onResponse(call: Call<ArrayList<DiscoverResponse>>?, response: Response<ArrayList<DiscoverResponse>>?) {
                if(response!!.code() == 200)
                callback.invoke(response.body())
            }

            override fun onFailure(call: Call<ArrayList<DiscoverResponse>>?, t: Throwable?) {
//                callback.invoke(null)
            }


        })
    }




}
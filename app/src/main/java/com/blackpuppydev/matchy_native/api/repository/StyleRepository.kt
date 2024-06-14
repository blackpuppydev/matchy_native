package com.blackpuppydev.matchy_native.api.repository

import com.blackpuppydev.matchy_native.api.ApiManager
import com.blackpuppydev.matchy_native.api.MainFragmentApi
import com.blackpuppydev.matchy_native.api.response.StyleResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StyleRepository {

    companion object {

        private var instance: StyleRepository? = null

        fun newInstance(): StyleRepository {
            if (instance == null) instance = StyleRepository()
            return instance!!
        }

    }


    fun getStyle(username:String,callback: (response:ArrayList<StyleResponse>) -> Unit){

        ApiManager.getRetrofit().create(MainFragmentApi::class.java).getDataStyle(username)
            .enqueue(object : Callback<ArrayList<StyleResponse>> {
                override fun onResponse(call: Call<ArrayList<StyleResponse>>?, response: Response<ArrayList<StyleResponse>>?) {
                    if (response?.code() == 200) callback.invoke(response.body())
                }

                override fun onFailure(call: Call<ArrayList<StyleResponse>>?, t: Throwable?) {
//                   callback.invoke(null)
                }
            })

    }

}
package com.blackpuppydev.matchy_native.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blackpuppydev.matchy_native.api.ApiManager
import com.blackpuppydev.matchy_native.api.UserApi
import com.blackpuppydev.matchy_native.api.response.ProfileResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileViewModel : ViewModel() {

    var detailProfile = MutableLiveData<ProfileResponse>()

    fun getProfile(){
        ApiManager.getRetrofit().create(UserApi::class.java).getProfile("").enqueue(object : Callback<ProfileResponse>{
            override fun onResponse(call: Call<ProfileResponse>?, response: Response<ProfileResponse>?) {
                detailProfile.postValue(response?.body())
            }

            override fun onFailure(call: Call<ProfileResponse>?, t: Throwable?) {
                Log.e("getProfile onFailure : ",t?.message.toString())
            }
        })
    }












}
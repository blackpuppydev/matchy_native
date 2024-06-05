package com.blackpuppydev.matchy_native.api.repository

import com.blackpuppydev.matchy_native.api.ApiManager
import com.blackpuppydev.matchy_native.api.UserApi
import com.blackpuppydev.matchy_native.api.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserRepository {

    companion object{
        private var instance: UserRepository? = null
        fun newInstance(): UserRepository {
            if (instance == null) instance = UserRepository()
            return instance!!
        }
    }



    fun getUserFromUsername(callback: (resp:UserResponse?) -> Unit){

        ApiManager.getRetrofit().create(UserApi::class.java).getUser("nattawut.c").enqueue(object :
            Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                callback.invoke(response?.body())
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                callback.invoke(null)
            }

        })
    }


    fun getUserCloset(username:String,callback: (resp: List<UserResponse>?) -> Unit){

    }

}
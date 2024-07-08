package com.blackpuppydev.matchy_native.api.repository

import android.util.Log
import com.blackpuppydev.matchy_native.BuildConfig
import com.blackpuppydev.matchy_native.api.ApiManager
import com.blackpuppydev.matchy_native.api.UserApi
import com.blackpuppydev.matchy_native.api.response.ClosetResponse
import com.blackpuppydev.matchy_native.api.response.UserResponse
import com.google.protobuf.Api
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


    fun addTestUser(user:UserResponse,callback: (resp: String?) -> Unit){
        ApiManager.getRetrofit().create(UserApi::class.java).addTestUserToServer(user).enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                callback.invoke(response?.body())
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                callback.invoke(t?.message)
            }

        })
    }


    fun getTestUserFromServer(callback: (resp: String?) -> Unit){

        ApiManager.getRetrofit().create(UserApi::class.java).getTestUserFromServer().enqueue(object : Callback<String>{
            override fun onResponse(call: Call<String>?, response: Response<String>?) {
                Log.e("getTestUserFromServer", "response : " + response?.body().toString())
                callback.invoke(response?.body().toString())
            }

            override fun onFailure(call: Call<String>?, t: Throwable?) {
                Log.e("getTestUserFromServer", "response : " + t?.message.toString())
                callback.invoke(t?.message.toString())
            }

        })
    }



    fun getUserFromUsername(username:String, password:String,callback: (resp:UserResponse?) -> Unit){
        //when debug
        ApiManager.getRetrofit().create(UserApi::class.java).getUser(BuildConfig.TEST_USERNAME).enqueue(object :
            Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                if (response?.body()?.password == password)
                    callback.invoke(response.body())
                else callback.invoke(null)
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                callback.invoke(null)
            }

        })
    }


    private fun checkLogin(username:String, password:String):Boolean {

        var successLogin = false

        ApiManager.getRetrofit().create(UserApi::class.java).getUserWithUsername(BuildConfig.TEST_USERNAME)
            .enqueue(object : Callback<UserResponse>{
            override fun onResponse(call: Call<UserResponse>?, response: Response<UserResponse>?) {
                if (response?.body()?.password == password)
                    successLogin = true
            }

            override fun onFailure(call: Call<UserResponse>?, t: Throwable?) {
                successLogin = false
            }
        })

        return successLogin

    }


    fun getUserCloset(username:String,callback: (resp: List<ClosetResponse>?) -> Unit){
        ApiManager.getRetrofit().create(UserApi::class.java).getCloset(BuildConfig.TEST_USERNAME)
            .enqueue(object : Callback<List<ClosetResponse>>{
            override fun onResponse(
                call: Call<List<ClosetResponse>>?,
                response: Response<List<ClosetResponse>>?
            ) {
                Log.e("getUserCloset : ",response?.body().toString())
                callback.invoke(response?.body())
            }

            override fun onFailure(call: Call<List<ClosetResponse>>?, t: Throwable?) {
                Log.e("getUserCloset : ",t?.message.toString())
                callback.invoke(null)
            }

        })
    }

}
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



    fun getUserFromUsername(username:String, password:String,callback: (resp:UserResponse?) -> Unit){

        ApiManager.getRetrofit().create(UserApi::class.java).getUser(username).enqueue(object :
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

        ApiManager.getRetrofit().create(UserApi::class.java).getUserWithUsername(username).enqueue(object : Callback<UserResponse>{
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


    fun getUserCloset(username:String,callback: (resp: List<UserResponse>?) -> Unit){

    }

}
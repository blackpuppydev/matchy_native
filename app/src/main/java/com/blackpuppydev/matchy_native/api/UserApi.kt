package com.blackpuppydev.matchy_native.api

import com.blackpuppydev.matchy_native.api.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    @GET("/api/user")
    fun getUser(@Query("username") test:String): Call<UserResponse>


    @POST("/api/user")
    fun getUserWithUsername(@Query("username") test:String): Call<UserResponse>

}
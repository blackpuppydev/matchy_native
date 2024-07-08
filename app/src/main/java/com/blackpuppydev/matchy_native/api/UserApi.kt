package com.blackpuppydev.matchy_native.api

import com.blackpuppydev.matchy_native.api.response.ClosetResponse
import com.blackpuppydev.matchy_native.api.response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApi {

    companion object{
        const val USER = "/api/user"
    }

    @GET(USER)
    fun getTestUserFromServer():Call<String>

    @POST(USER)
    fun addTestUserToServer(@Body user:UserResponse):Call<String>

    @GET(USER)
    fun getUser(@Query("username") test:String): Call<UserResponse>

    @POST(USER)
    fun getUserWithUsername(@Query("username") test:String): Call<UserResponse>

    @GET("$USER/closet")
    fun getCloset(@Query("username") username:String) : Call<List<ClosetResponse>>

}
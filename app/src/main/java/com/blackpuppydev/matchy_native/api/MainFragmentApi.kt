package com.blackpuppydev.matchy_native.api

import com.blackpuppydev.matchy_native.api.response.DiscoverResponse
import com.blackpuppydev.matchy_native.api.response.StyleResponse
import com.blackpuppydev.matchy_native.api.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface MainFragmentApi {


    @GET("/api/user/discover")
    fun getDataDiscover(@Query("user") username:String): Call<ArrayList<DiscoverResponse>>


    @GET("/api/user/style")
    fun getDataStyle(@Query("username") test:String): Call<ArrayList<StyleResponse>>



}
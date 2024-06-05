package com.blackpuppydev.matchy_native.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiManager {


    companion object{

        fun getRetrofit() : Retrofit {
            val builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl("http://172.18.2.93:8080")
                .addConverterFactory(GsonConverterFactory.create())
//            .client(getOkHttpClient())
            return builder.build()
        }


        fun getOkHttpClient(): OkHttpClient? {
            return null
        }


    }
}
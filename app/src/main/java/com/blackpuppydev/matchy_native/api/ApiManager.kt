package com.blackpuppydev.matchy_native.api

import com.blackpuppydev.matchy_native.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiManager {


    companion object{

        fun getRetrofit() : Retrofit {
            val builder: Retrofit.Builder = Retrofit.Builder()
                .baseUrl(BuildConfig.END_POINT)
                .addConverterFactory(getConvertFactory())
//            .client(getOkHttpClient())
            return builder.build()
        }


        fun getOkHttpClient(): OkHttpClient? {
            return null
        }

        private fun getConvertFactory():GsonConverterFactory{
            return GsonConverterFactory.create(GsonBuilder()
                .setLenient()
                .setPrettyPrinting()
                .create())
        }

    }



}
package com.blackpuppydev.matchy_native.listener

interface MainFragmentEvent {


    fun onSuccess()
    fun onResult(result:String,landingPage:String)


    //mode
    fun setNightMode(enableNightMode:Boolean)

}
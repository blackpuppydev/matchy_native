package com.blackpuppydev.matchy_native.listener

interface FragmentEvent {
    fun onSuccess()
    fun onResult(result:String,type:String,landingPage:String)
}
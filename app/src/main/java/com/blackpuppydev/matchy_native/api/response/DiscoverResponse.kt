package com.blackpuppydev.matchy_native.api.response

data class DiscoverResponse (
        var id: String = "",
        var name: String = "",
        var lastName:String = "",
        var pairing:Int = 0,
        var follower:Int = 0,
        var activity:String = "",
        var imgProfile:String = ""
        )
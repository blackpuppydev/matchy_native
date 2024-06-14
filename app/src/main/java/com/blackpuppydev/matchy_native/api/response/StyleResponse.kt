package com.blackpuppydev.matchy_native.api.response


data class StyleResponse (
    var name:String = "",
    var currentTime : String = "",
    var profileImage : String = "",
    var listImg:ArrayList<String>
)
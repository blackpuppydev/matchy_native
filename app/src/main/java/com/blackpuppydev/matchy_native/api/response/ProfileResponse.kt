package com.blackpuppydev.matchy_native.api.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileResponse (
    var name:String,
    var lastName:String,
    var follower:Int,
    var gender:String,
    var skin:String,
    var age:Int,
    var height:Int
        ) : Parcelable
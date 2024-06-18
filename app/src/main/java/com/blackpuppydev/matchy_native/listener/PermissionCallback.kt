package com.blackpuppydev.matchy_native.listener

interface PermissionCallback {


    fun permissionGranted(type:String,granted:Boolean)
}
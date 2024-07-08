package com.blackpuppydev.matchy_native.manager

import android.annotation.SuppressLint
import android.content.Context
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat.getSystemService


object Device {


    @SuppressLint("HardwareIds")
    fun getImei(context:Context):String{
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.deviceId
    }


    @SuppressLint("HardwareIds")
    fun getSimSerial(context:Context):String{
        val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
        return telephonyManager.simSerialNumber
    }



}
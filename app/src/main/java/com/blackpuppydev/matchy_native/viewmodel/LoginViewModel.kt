package com.blackpuppydev.matchy_native.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blackpuppydev.matchy_native.AppPreference
import com.blackpuppydev.matchy_native.api.repository.UserRepository
import com.blackpuppydev.matchy_native.dialog.StandardDialog

class LoginViewModel : ViewModel() {

    var loginSuccess:Boolean = false
    var appPreference: AppPreference = AppPreference.getInstance()

    var dialogLiveData = MutableLiveData<Unit>()


    fun checkLogin(username:String,password:String){
        UserRepository.newInstance().getUserFromUsername(username, password) { user ->
            if (user != null){
                loginSuccess = true
            }
        }
    }

    fun setUserPreference(context: Context,username: String,password: String){
        appPreference.setSharedPreference(context)
        //save share pref
        appPreference.setUsername(username)
        appPreference.setPassword(password)
    }


    fun getErrorDialog(context: Context,title:String){

//        dialogLiveData.postValue(object : StandardDialog(context) {
//            override fun onCancelClick() {
//                dismiss()
//            }
//        }.show(title))
        object : StandardDialog(context) {
            override fun onCancelClick() {
                dismiss()
            }
        }.show(title)
    }

}
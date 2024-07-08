package com.blackpuppydev.matchy_native.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import com.blackpuppydev.matchy_native.AppPreference
import com.blackpuppydev.matchy_native.api.repository.UserRepository
import com.blackpuppydev.matchy_native.api.response.UserResponse
import com.blackpuppydev.matchy_native.database.UserDatabase
import com.blackpuppydev.matchy_native.database.entity.UsersEntity
import com.blackpuppydev.matchy_native.dialog.StandardDialog
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var loginSuccess:Boolean = false
    var appPreference: AppPreference = AppPreference.getInstance()

    fun callTestConnectDatabase(){
        UserRepository.newInstance().getTestUserFromServer {
            Log.e("callTestConnectDatabase", "connect success")
        }

//        val user = UserResponse("1","Nattawut","Chitsaad","nattawut.c","1234","shop@gmail.com")
//
//        UserRepository.newInstance().addTestUser(user){
//            Log.e("callTestConnectDatabase", "connect success : $it")
//        }
    }


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



    fun setUser(context: Context, user: UsersEntity){
        GlobalScope.launch {
            UserDatabase.getUserDatabase(context)
                .userDao().insertUser(user)

//            getUser(context)
        }
    }

//    private fun getUser(context: Context){
//        Log.e("LoginViewModel : " ,UserDatabase.getUserDatabase(context).userDao().getUser().size.toString() )
//    }

}
package com.example.mvvmtest.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmtest.data.repository.UserRepository
import com.example.mvvmtest.utils.ApiException
import com.example.mvvmtest.utils.Coroutines
import com.example.mvvmtest.utils.NoInternetException

/**
 * Created by Ahsanul Kabir on 5/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
class AuthViewModel(
    private var userRepository: UserRepository
): ViewModel(){
    var email:String? = null
    var password:String? = null

    var authlistner:AuthListner? = null

    fun getLoggedUser() = userRepository.getSavedUser()

    fun onLoginButtonClicked(view:View){
        authlistner?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){
            authlistner?.onFailure("Password field are empty")
            return
        }
        Coroutines.main{
            try {
                val response = userRepository.userLogin(email!!, password!!)
                response.user?.let {
                    authlistner?.onSuccess(response = it)
                    userRepository.saveUser(user = it)
                    return@main
                }
                authlistner?.onFailure(response.message!!)
            }catch (e: ApiException){
                authlistner?.onFailure(e.message!!)
            }catch (e: NoInternetException){
                authlistner?.onFailure(e.message!!)
            }

        }

    }
}
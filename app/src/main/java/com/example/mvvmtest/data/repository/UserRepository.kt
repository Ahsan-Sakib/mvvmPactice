package com.example.mvvmtest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmtest.data.network.MyApi
import com.example.mvvmtest.data.network.authresponse.AuthResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Ahsanul Kabir on 6/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
class UserRepository {

    suspend fun userLogin(email:String,password:String):Response<AuthResponse> {
        val loginResponse = MyApi().userLogin(email,password)

        return loginResponse
    }
}
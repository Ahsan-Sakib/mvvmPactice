package com.example.mvvmtest.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import com.example.mvvmtest.data.db.AppDatabase
import com.example.mvvmtest.data.db.entity.User
import com.example.mvvmtest.data.network.MyApi
import com.example.mvvmtest.data.network.SafeApiRequest
import com.example.mvvmtest.data.network.authresponse.AuthResponse
import com.example.mvvmtest.utils.ApiException
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Ahsanul Kabir on 6/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
class UserRepository(
   private val api: MyApi,
   private val db : AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email:String,password:String): AuthResponse {
       return apiRequest{api.userLogin(email,password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upInsert(user)

    fun getSavedUser() = db.getUserDao().getUser()
}
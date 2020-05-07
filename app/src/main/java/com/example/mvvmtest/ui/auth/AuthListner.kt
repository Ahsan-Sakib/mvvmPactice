package com.example.mvvmtest.ui.auth

import androidx.lifecycle.LiveData
import com.example.mvvmtest.data.db.entity.User
import com.example.mvvmtest.data.network.authresponse.AuthResponse
import retrofit2.Response

/**
 * Created by Ahsanul Kabir on 5/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
interface AuthListner {
    fun onStarted()
    fun onSuccess(response: User)
    fun onFailure(message: String)
}
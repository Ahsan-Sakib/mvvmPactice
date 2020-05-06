package com.example.mvvmtest.ui.auth

/**
 * Created by Ahsanul Kabir on 5/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
interface AuthListner {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message: String)
}
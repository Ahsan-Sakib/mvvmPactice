package com.example.mvvmtest.data.network.authresponse

import com.example.mvvmtest.data.db.entity.User

/**
 * Created by Ahsanul Kabir on 7/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
data class  AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?
)
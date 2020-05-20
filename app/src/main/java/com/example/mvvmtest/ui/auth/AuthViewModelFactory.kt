package com.example.mvvmtest.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.data.repository.UserRepository

/**
 * Created by Ahsanul Kabir on 8/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
    var repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(userRepository = repository) as T
    }
}

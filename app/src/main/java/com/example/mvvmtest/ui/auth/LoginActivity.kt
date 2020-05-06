package com.example.mvvmtest.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.R
import com.example.mvvmtest.databinding.LoginActivityBinding
import com.example.mvvmtest.utils.toast

class LoginActivity : AppCompatActivity(),AuthListner {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: LoginActivityBinding = DataBindingUtil.setContentView(this,R.layout.login_activity)
        var viewModelProvider = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModelProvider

        viewModelProvider.authlistner = this
    }

    override fun onStarted() {
        toast("login started")

    }

    override fun onSuccess() {
        toast("login success")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}

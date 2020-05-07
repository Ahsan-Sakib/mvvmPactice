package com.example.mvvmtest.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.mvvmtest.R
import com.example.mvvmtest.data.db.entity.User
import com.example.mvvmtest.databinding.LoginActivityBinding
import com.example.mvvmtest.utils.hide
import com.example.mvvmtest.utils.show
import com.example.mvvmtest.utils.toast
import kotlinx.android.synthetic.main.login_activity.*

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
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        toast("${user.name} is logged in")
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}

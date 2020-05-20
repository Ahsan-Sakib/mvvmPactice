package com.example.mvvmtest.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmtest.R
import com.example.mvvmtest.data.db.entity.User
import com.example.mvvmtest.databinding.LoginActivityBinding
import com.example.mvvmtest.utils.hide
import com.example.mvvmtest.utils.show
import com.example.mvvmtest.utils.snackbar
import com.example.mvvmtest.utils.toast
import kotlinx.android.synthetic.main.login_activity.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity(),AuthListner,KodeinAware {

    override val kodein by kodein()
    private val factory: AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding:  LoginActivityBinding = DataBindingUtil.setContentView(this,R.layout.login_activity)
        var viewModel = ViewModelProvider(this,factory).get(AuthViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.authlistner = this

        viewModel.getLoggedUser().observe(this, Observer {user ->
            if(user!=null){
                Intent(this,HomeActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
            }
        })
    }

    override fun onStarted() {
        toast("login started")
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        root_layout.snackbar("${user.name} is logged in")
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}

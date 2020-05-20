package com.example.mvvmtest.data.network

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.mvvmtest.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by Ahsanul Kabir on 8/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
class NetworkConnectionInceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext


    @RequiresApi(Build.VERSION_CODES.M)
    override fun intercept(chain: Interceptor.Chain): Response {
            if (!isInternetAvilable()){
                throw NoInternetException("Make sure network is available")
                Log.i("Test", "Triggered")
            }
        return chain.proceed(chain.request())
    }


    @RequiresApi(Build.VERSION_CODES.M)
    private fun isInternetAvilable() : Boolean{
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = connectivityManager.activeNetwork
        connectivityManager.getNetworkCapabilities(activeNetwork).also {
            return it!= null && it.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        }
    }
}
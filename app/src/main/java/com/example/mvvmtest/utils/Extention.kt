package com.example.mvvmtest.utils

import android.content.Context
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast

/**
 * Created by Ahsanul Kabir on 5/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */

fun Context.toast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}

fun ProgressBar.show(){
    visibility = View.VISIBLE
}

fun ProgressBar.hide(){
    visibility = View.GONE
}
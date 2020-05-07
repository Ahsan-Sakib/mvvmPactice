package com.example.mvvmtest.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by Ahsanul Kabir on 7/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
object Coroutines {

    fun main(work: suspend(()-> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            work()
        }
}
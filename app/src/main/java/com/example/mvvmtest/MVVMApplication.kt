package com.example.mvvmtest

import android.app.Application
import com.example.mvvmtest.data.db.AppDatabase
import com.example.mvvmtest.data.network.MyApi
import com.example.mvvmtest.data.network.NetworkConnectionInceptor
import com.example.mvvmtest.data.repository.UserRepository
import com.example.mvvmtest.ui.auth.AuthViewModel
import com.example.mvvmtest.ui.auth.AuthViewModelFactory
import com.example.mvvmtest.ui.auth.LoginActivity
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * Created by Ahsanul Kabir on 10/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
class MVVMApplication : Application(),KodeinAware{

    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
    }
}
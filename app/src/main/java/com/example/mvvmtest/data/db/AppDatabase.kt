package com.example.mvvmtest.data.db

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmtest.data.db.entity.User

/**
 * Created by Ahsanul Kabir on 7/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
@Database(
    entities = [User::class] ,
    version = 1
)
abstract class AppDatabase: RoomDatabase(){

   abstract fun getUserDao(): UserDao
    companion object {
        @Volatile
        private var instances: AppDatabase? = null
        private var LOCK = Any()

        operator fun invoke(context: Context) = instances ?: synchronized(LOCK){
            instances?:buildRoomDatabase(context).also {
                instances = it
            }
        }


        private fun buildRoomDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "userTable"
            ).build()
    }

}
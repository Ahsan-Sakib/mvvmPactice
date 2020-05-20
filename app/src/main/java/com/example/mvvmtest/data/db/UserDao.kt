package com.example.mvvmtest.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mvvmtest.data.db.entity.CURRENT_USER_ID
import com.example.mvvmtest.data.db.entity.User

/**
 * Created by Ahsanul Kabir on 7/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */

@Dao
interface UserDao {
    //for insert or replace value to table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upInsert(user: User): Long

    //return user
    @Query(value = "SELECT * FROM User WHERE uId = $CURRENT_USER_ID")
    fun getUser() : LiveData<User>
}
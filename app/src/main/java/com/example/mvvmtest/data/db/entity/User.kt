package com.example.mvvmtest.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Ahsanul Kabir on 7/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */
const val CURRENT_USER_ID = 0

@Entity
data class User(
    var id: Int? = null,
    var name: String? = null,
    var email: String? = null,
    var password: String? = null,
    var email_varified_at: String? = null,
    var created_at: String? = null,
    var updated_at: String? = null
){
    @PrimaryKey(autoGenerate = false)
    var uId: Int = CURRENT_USER_ID
}
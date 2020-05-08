package com.example.mvvmtest.data.network

import com.example.mvvmtest.utils.ApiException
import com.google.gson.JsonObject
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.lang.StringBuilder

/**
 * Created by Ahsanul Kabir on 8/5/20
 * Copyright (c) 2020 bjit. All rights reserved.
 * ahsanul.kabir@bjitgroup.com
 */

abstract class SafeApiRequest{
    suspend fun<T: Any>  apiRequest(call : suspend ()-> Response<T> ):T{
        val response = call.invoke() //what is this??

        if (response.isSuccessful){
            return response.body()!!
        }else{
            val error = response.errorBody().toString()

            val message = StringBuilder()
            error.let {
                try{
                    message.append(JSONObject(it).getString("message"))
                }catch (e: JSONException){}
                message.append("\n")
            }
            message.append("${response.code()}")
            throw ApiException(message = message.toString())
        }
    }
}
package com.example.yudizapplication.Retrofit.api

import com.example.yudizapplication.Retrofit.Data_User
import retrofit2.Call

import retrofit2.http.GET
import retrofit2.http.PUT

interface User_API{
    @GET("/api/users")
    fun getUser() : Call<List<Data_User>>

}

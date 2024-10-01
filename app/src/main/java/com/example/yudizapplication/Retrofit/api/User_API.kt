package com.example.yudizapplication.Retrofit.api

import com.example.yudizapplication.Retrofit.model.Data_User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface User_API {
    @GET("users")
    fun getUser(): Call<List<Data_User>>

    @POST("users")
    fun addUser(@Body user: Data_User): Call<List<Data_User>>

    @PUT("users/{id}")
    fun updateUser(@Path("id") id: String, @Body user: Data_User): Call<Data_User>

    @DELETE("users/{id}")
    fun deleteUser(@Path("id") id: String): Call<Data_User>

}

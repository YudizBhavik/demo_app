package com.example.yudizapplication.Retrofit.model

import com.google.gson.annotations.SerializedName

data class Data_User(
  @SerializedName("id")  val id: String,
    val name: String,
    val age: Int,
    val company: String
)

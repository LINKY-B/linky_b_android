package com.example.linkybproject.myprofile

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MyProfileInterface {
    @GET("users")
    fun getUser(
        @Header("Authorization") token: String
    ): Call<MyProfileResponse>
}

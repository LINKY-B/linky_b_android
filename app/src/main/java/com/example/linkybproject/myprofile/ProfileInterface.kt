package com.example.linkybproject.myprofile

import com.example.linkybproject.connect.LBUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ProfileInterface {
    @GET("users")
    fun getUser(
        @Header("Authorization") token: String
    ): Call<MyProfileResponse>

}

package com.example.linkybproject.myprofile

import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.PATCH

interface ActiveInterface {
    @PATCH("/users/active")
    fun turnOnTheInfo(
        @Header("Authorization") token: String
    ): Call<ActiveResponse>

    @PATCH("/users/inactive")
    fun turnOffTheInfo(
        @Header("Authorization") token: String
    ): Call<ActiveResponse>
}
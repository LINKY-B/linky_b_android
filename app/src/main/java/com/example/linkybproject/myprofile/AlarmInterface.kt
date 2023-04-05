package com.example.linkybproject.myprofile

import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.PATCH

interface AlarmInterface {
    @PATCH("/users/alarm")
    fun turnOnTheNotice(
        @Header("Authorization") token: String
    ): Call<AlarmResponse>

    @PATCH("/users/alarm/inactive")
    fun turnOffTheNotice(
        @Header("Authorization") token: String
    ): Call<AlarmResponse>
}
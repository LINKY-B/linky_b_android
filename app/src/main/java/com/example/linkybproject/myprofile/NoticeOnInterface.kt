package com.example.linkybproject.myprofile

import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.PATCH

interface NoticeOnInterface {
    @PATCH("/users/alarm")
    fun turnOnTheNotice(
        @Header("Authorization") token: String
    ): Call<NoticeResponse>

    @PATCH("/users/alarm/inactive")
    fun turnOffTheNotice(
        @Header("Authorization") token: String
    ): Call<NoticeResponse>
}
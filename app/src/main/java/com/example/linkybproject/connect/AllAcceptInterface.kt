package com.example.linkybproject.connect

import retrofit2.Call
import retrofit2.http.Header
import retrofit2.http.PATCH

interface AllAcceptInterface {
    @PATCH("/match/all")
    fun matchingAll(
        @Header("Authorization") token: String
    ): Call<AllMatchingResponse>
}
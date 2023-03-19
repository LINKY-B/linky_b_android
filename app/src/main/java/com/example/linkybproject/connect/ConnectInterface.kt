package com.example.linkybproject.connect

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ConnectInterface {
    @GET("match/getMatched/all")
    fun connectToMeList(
        @Header("Bearer") token: String
    ): Call<MatchingResponse>
}
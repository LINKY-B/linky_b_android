package com.example.linkybproject.connect

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ConnectInterface {
    @GET("match/getMatched/all")
    fun connectToMeList(
        @Header("Authorization") token: String
    ): Call<MatchingResponse>

    @GET("match/Matching/all")
    fun connectFromMeList(
        @Header("Authorization") token: String
    ): Call<MatchingResponse>
}


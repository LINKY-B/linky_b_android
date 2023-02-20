package com.example.linkybproject.connect

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface MatchingListInterface {
    @GET("/match/main")
    fun showMatchingList(
        @Header ("Authorization") token : String
    ) : Call<MatchingListResponse>
}
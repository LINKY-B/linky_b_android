package com.example.linkybproject.myprofile

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface BlockListInterface {
    @GET("/users/block")
    fun getBlockList(
        @Header("Authorization") token: String
    ): Call<BlockListResponse>
}
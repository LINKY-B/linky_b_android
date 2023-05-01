package com.example.linkybproject.myprofile

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.PATCH

interface UnblockInterface {
    @PATCH("/users/block")
    fun unblock(
        @Header("Authorization") token: String,
        @Body unblockRequest: UnblockRequest
    ): Call<UnblockResponse>
}
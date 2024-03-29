package com.example.linkybproject.auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/auth/login")
    fun login(
        @Body loginRequest: LoginRequest
    ): Call<LoginResponse>

    @POST("/auth/reissue")
    fun reissue(
        @Header("Authorization") token: String
    ): Call<ReissueResponse>

    // FindPasswordEmail
    @POST("/auth/reset-password/send-email")
    fun getEmail(
        @Body findPasswordEmailRequest: FindPasswordEmailRequest
    ): Call<FindPasswordEmailResponse>

    // SetNewPassword
    @POST("/auth/reset-password")
    fun changePW(
        @Body findPasswordRequest: FindPasswordRequest
    ): Call<FindPasswordResponse>
}
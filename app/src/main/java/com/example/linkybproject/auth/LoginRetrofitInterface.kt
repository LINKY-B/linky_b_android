package com.example.linkybproject.auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("/users/auth/login")
    fun login(@Body loginRequest: LoginRequest): Call<LoginResponse>
}
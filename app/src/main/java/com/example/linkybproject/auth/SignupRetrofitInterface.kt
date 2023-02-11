package com.example.linkybproject.auth

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupRetrofitInterface {
    @POST("/users/auth/signup") // @Method(api address)
    fun signup(@Body signupRequest: SignupRequest): Call<SignupResponse>
}
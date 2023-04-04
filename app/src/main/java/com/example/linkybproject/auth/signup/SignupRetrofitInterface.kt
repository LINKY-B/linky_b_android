package com.example.linkybproject.auth.signup

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignupRetrofitInterface {
    @POST("/users/auth/signup") // @Method(api address)
    fun signup(@Body signupRequest: SignupRequest): Call<SignupResponse>

    @POST("/auth/signup/send-email")
    fun emailAuth(@Body emailAuthRequest: EmailAuthRequest): Call<EmailAuthResponse>

    @POST("/auth/signup/confirm-email")
    fun emailAuthCheck(@Body emailAuthCheckRequest: EmailAuthCheckRequest): Call<EmailAuthCheckResponse>

    @POST("/auth/check-nickname")
    fun nickName(@Body nicknameRequest: NicknameRequest): Call<NicknameResponse>

    
}
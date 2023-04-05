package com.example.linkybproject.auth.signup

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface SignupRetrofitInterface {

    @POST("/auth/signup/send-email")
    fun emailAuth(@Body emailAuthRequest: EmailAuthRequest): Call<EmailAuthResponse>

    @POST("/auth/signup/confirm-email")
    fun emailAuthCheck(@Body emailAuthCheckRequest: EmailAuthCheckRequest): Call<EmailAuthCheckResponse>

    @POST("/auth/check-nickname")
    fun nickName(@Body nicknameRequest: NicknameRequest): Call<NicknameResponse>

    @GET("/auth/profile-images")
    fun getProfileImages(): Call<ProfileImagesResponse>

    @Multipart
    @POST("/auth/signup")
    fun signup(
        @Part ("UserSignupReq") userSignupReq: UserSignupReq,
        @Part schoolImg: MultipartBody.Part
    ): Call<SignupResponse>
}
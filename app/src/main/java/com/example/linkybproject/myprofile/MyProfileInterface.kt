package com.example.linkybproject.myprofile

import com.example.linkybproject.myprofile.update.MyProfileUpdateRequest
import com.example.linkybproject.myprofile.update.MyProfileUpdateResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PATCH

interface MyProfileInterface {
    @GET("users")
    fun getUser(
        @Header("Authorization") token: String
    ): Call<MyProfileResponse>

    @PATCH("/users/modifyProfile")
    fun updateMyProfile(@Body myProfileUpdateRequest: MyProfileUpdateRequest): Call<MyProfileUpdateResponse>

}

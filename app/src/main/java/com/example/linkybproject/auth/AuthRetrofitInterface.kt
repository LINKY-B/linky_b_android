package com.example.linkybproject.auth

import retrofit2.http.GET
import retrofit2.http.POST

interface AuthRetrofitInterface {
    @POST("/users/auth/login")
}
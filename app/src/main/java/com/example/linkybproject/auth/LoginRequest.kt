package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName(value = "email") val email: String,
    @SerializedName(value = "password") val password: String
)

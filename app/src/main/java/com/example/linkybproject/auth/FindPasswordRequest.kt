package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class FindPasswordRequest (
    @SerializedName(value = "authCode") var authCode: String,
    @SerializedName(value = "email") var email: String,
    @SerializedName(value = "password") var password: String
)
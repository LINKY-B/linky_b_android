package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName(value = "phone") val phone: Int
)

package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName

data class SignupResponse(
    @SerializedName(value = "phone") val phone: String
)

package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName

data class EmailAuthResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: String
)
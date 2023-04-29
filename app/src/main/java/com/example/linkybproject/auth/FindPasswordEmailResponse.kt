package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class FindPasswordEmailResponse (
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: String
)
package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName

data class ProfileImagesResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: ArrayList<String>
)

package com.example.linkybproject.myprofile

import com.google.gson.annotations.SerializedName

data class UnblockResponse(
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "data") val data: UnblockData,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int
)

data class UnblockData(
    @SerializedName(value = "userId") val userId: Int
)
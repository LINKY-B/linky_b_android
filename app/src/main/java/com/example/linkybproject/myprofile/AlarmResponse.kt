package com.example.linkybproject.myprofile

import com.google.gson.annotations.SerializedName

data class AlarmResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: Result
)

data class Result (
    @SerializedName(value = "userId") val userId: Int
)
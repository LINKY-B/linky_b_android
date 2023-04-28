package com.example.linkybproject.myprofile

import com.google.gson.annotations.SerializedName

data class ActiveResponse(
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "data") val data: ActiveData,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int
)

data class ActiveData (
    @SerializedName(value = "userId") val userId: Int
)
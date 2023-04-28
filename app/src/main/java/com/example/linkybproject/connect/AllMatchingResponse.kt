package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class AllMatchingResponse(
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "data") val data: AllMatchingData,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int
)

data class AllMatchingData (
    @SerializedName(value = "userGetMatched") val userGetMatched: Int
)

package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class MatchingResponse (
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "data") val data: ArrayList<LBUser>,
)
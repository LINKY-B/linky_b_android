package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class MatchingResponse (
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: List<LBUser>
)
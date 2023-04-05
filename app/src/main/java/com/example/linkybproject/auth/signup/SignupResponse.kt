package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName
import java.util.Objects

data class SignupResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: String // 타입 다시 보기
)

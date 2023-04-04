package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName

data class EmailAuthCheckRequest(
    @SerializedName(value = "authCode") var authCode: String,
    @SerializedName(value = "email") var email: String,
    @SerializedName(value = "userNickName") var userNickName: String
)

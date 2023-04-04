package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName

data class EmailAuthRequest(
    @SerializedName(value = "email") var email: String,
    @SerializedName(value = "userNickName") var userNickName: String
)
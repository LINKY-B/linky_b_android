package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName

data class NicknameRequest(
    @SerializedName(value = "nickName") var nickName: String
)

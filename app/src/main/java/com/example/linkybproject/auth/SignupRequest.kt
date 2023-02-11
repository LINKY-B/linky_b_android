package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName(value = "userName") var userName: String

)

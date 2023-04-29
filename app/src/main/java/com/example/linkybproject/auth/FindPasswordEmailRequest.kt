package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class FindPasswordEmailRequest (
    @SerializedName(value = "email") var email: String
)
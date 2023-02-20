package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class ConnectRequest(
    @SerializedName(value = "Authorization") val Authorization: String
)

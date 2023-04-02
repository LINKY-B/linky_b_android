package com.example.linkybproject.homes

import com.google.gson.annotations.SerializedName

data class HomeStudentRequest(
    @SerializedName(value = "Bearer") val Authorization: String
)

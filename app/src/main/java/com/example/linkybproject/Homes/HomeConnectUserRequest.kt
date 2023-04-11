package com.example.linkybproject.Homes

import com.google.gson.annotations.SerializedName

data class HomeProfileRequest(
    @SerializedName(value = "userId") var userId: Int
)

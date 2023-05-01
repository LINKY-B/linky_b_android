package com.example.linkybproject.myprofile

import com.google.gson.annotations.SerializedName

data class UnblockRequest(
    @SerializedName(value = "targetUserIds") var targetUserIds: List<Int>
)
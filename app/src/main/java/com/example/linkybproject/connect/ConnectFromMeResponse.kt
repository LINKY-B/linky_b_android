package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class ConnectFromMeResponse(
    @SerializedName(value = "userId") val userId: Long,
    @SerializedName(value = "userNickName") val userNickName: String,
    @SerializedName(value = "userMajorName") val userMajorName: String,
    @SerializedName(value = "userStudentNum") val userStudentNum: Long,
    @SerializedName(value = "userProfileImg") val userProfileImg: String,
    @SerializedName(value = "userLikeCount") val userLikeCount: Long
)

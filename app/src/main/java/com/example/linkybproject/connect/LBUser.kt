package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class LBUser (
    @SerializedName("userId") val userId: Long,
    @SerializedName("userNickName") val userNickName: String,
    @SerializedName("userMajorName") val userMajorName: String,
    @SerializedName("userStudentNum") val userStudentNum: String,
    @SerializedName("userLikeCount") val userLikeCount: Long,
    @SerializedName("userInterest") val userInterest: List<LBUserInterest>,
)

data class LBUserInterest (
    @SerializedName("createdAt") val createdAt: String,
    @SerializedName("updatedAt") val updatedAt: String,
    @SerializedName("id") val id: Long,
    @SerializedName("userInterest") val userInterest: String
)

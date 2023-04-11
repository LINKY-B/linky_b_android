package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class LBUser (
    @SerializedName("userId") val userId: Long,
    @SerializedName("userNickName") val userNickName: String,
    @SerializedName("userMajorName") val userMajorName: String,
    @SerializedName("userStudentNum") val userStudentNum: String,
    @SerializedName("userLikeCount") val userLikeCount: Long,
    @SerializedName("userMatchingCount") val userMatchingCount: Long,
    @SerializedName("userInterest") val userInterest: List<String>,
    @SerializedName("userSelfIntroduction") val userSelfIntroduction: String,
    @SerializedName("userMBTI") val userMBTI: String,
)


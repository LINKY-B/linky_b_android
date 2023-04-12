package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class LBUser (
    @SerializedName("userId") val userId: Long,
    @SerializedName("userProfileImg") val userProfileImg: String,
    @SerializedName("userNickName") val userNickName: String,
    @SerializedName("userLikeCount") val userLikeCount: Long,
    @SerializedName("userSelfIntroduction") val userSelfIntroduction: String,
    @SerializedName("userMatchingCount") val userMatchingCount: Long,
    @SerializedName("userMajorName") val userMajorName: String,
    @SerializedName("userStudentNum") val userStudentNum: String,
    @SerializedName("userBirth") val userBirth: String,
    @SerializedName("userSex") val userSex: String,
    @SerializedName("userMBTI") val userMBTI: String,
    @SerializedName("userPersonality") val userPersonality: List<String>,
    @SerializedName("userInterest") val userInterest: List<String>,
)


package com.example.linkybproject.myprofile

import com.google.gson.annotations.SerializedName

data class BlockListResponse(
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "data") val data: BlockData,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int
)

data class BlockData(
    @SerializedName(value = "userId") val userId: Int,
    @SerializedName(value = "userInterest") val userInterest: List<String>,
    @SerializedName(value = "userLikeCount") val userLikeCount: Int,
    @SerializedName(value = "userMajorName") val userMajorName: String,
    @SerializedName(value = "userNickName") val userNickName: String,
    @SerializedName(value = "userProfileImg") val userProfileImg: String,
    @SerializedName(value = "userStudentNum") val userStudentNum: String
    )
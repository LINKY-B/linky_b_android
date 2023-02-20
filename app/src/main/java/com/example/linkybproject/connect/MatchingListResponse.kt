package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class MatchingListResponse(
    @SerializedName(value = "나에게 연결을 시도한 회원") val connectToMe: ArrayList<User>,
    @SerializedName(value = "내가 연결을 시도한 회원") val connectFromMe: ArrayList<User>
)

data class User(
    @SerializedName(value = "userId") val userId: Long,
    @SerializedName(value = "userNickName") val userNickName: String,
    @SerializedName(value = "userMajorName") val userMajorName: String,
    @SerializedName(value = "userStudentNum") val userStudentNum: Long,
    @SerializedName(value = "userProfileImg") val userProfileImg: String,
    @SerializedName(value = "userLikeCount") val userLikeCount: Long,
    @SerializedName(value = "userInterest") val userInterest: ArrayList<Interests>
)

data class Interests(
    @SerializedName(value = "userInterest") val userInterest: String
)
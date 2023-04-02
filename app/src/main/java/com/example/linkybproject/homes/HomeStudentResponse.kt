package com.example.linkybproject.homes

import com.google.gson.annotations.SerializedName

//
data class HomeStudentResponse(
    @SerializedName(value = "isSuccess") val isSuccess: Boolean,
    @SerializedName(value = "code") val code: Int,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "result") val result: List<HomeStudentResult>
    )


data class HomeStudentResult(
    @SerializedName(value = "userNickname") var username: String,
    @SerializedName(value = "userMajorName") var department: String,
    @SerializedName(value = "userStudentNum") var studentnum: Long,
    @SerializedName(value = "userProfileImg") var userImg: String,
    @SerializedName(value = "userLikeCount") var likecount: Long,
    @SerializedName(value = "userInterest") var interest : List<Interest>
)

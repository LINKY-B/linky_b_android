package com.example.linkybproject.homes

import com.google.gson.annotations.SerializedName

//
data class HomeStudentResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: HomeStudentData
    )

data class HomeGraduateResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: HomeGraduateData
)

data class HomeStudentData(
    @SerializedName(value = "재학생 유저 리스트") val students: List<HomeStudentResult>
)
data class HomeGraduateData(
    @SerializedName(value = "졸업생 유저 리스트") val graduates: List<HomeStudentResult>,
)


data class HomeStudentResult(
    @SerializedName(value = "userNickName") var username: String,
    @SerializedName(value = "userMajorName") var department: String,
    @SerializedName(value = "userStudentNum") var studentnum: Long,
    @SerializedName(value = "userProfileImg") var userImg: String,
    @SerializedName(value = "userLikeCount") var likecount: Long,
    @SerializedName(value = "userInterest") var interest : List<String>
)

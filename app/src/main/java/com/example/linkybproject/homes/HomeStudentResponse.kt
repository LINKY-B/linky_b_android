package com.example.linkybproject.homes

import com.google.gson.annotations.SerializedName

// 1. 재학생 리스트 조회
data class HomeStudentResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: HomeStudentData
    )

// 2. 졸업생 리스트 조회
data class HomeGraduateResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: HomeGraduateData
)

// 1-1
data class HomeStudentData(
    @SerializedName(value = "재학생 유저 리스트") val students: List<HomeStudentResult>
)

// 2-1
data class HomeGraduateData(
    @SerializedName(value = "졸업생 유저 리스트") val graduates: List<HomeStudentResult>,
)

// 1-2, 2-2
data class HomeStudentResult(
    @SerializedName(value = "userNickName") var username: String,
    @SerializedName(value = "userMajorName") var department: String,
    @SerializedName(value = "userStudentNum") var studentnum: Long,
    @SerializedName(value = "userProfileImg") var userImg: String,
    @SerializedName(value = "userLikeCount") var likecount: Long,
    @SerializedName(value = "userInterest") var interest : List<String>
)

// 3. 홈 연결 시도 api
data class HomeConnectResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: HomeConnectData
)

// 3-1
data class HomeConnectData(
    @SerializedName(value = "matchId") val matchId: Int
)

// 4. 홈 화면 프로필 조회
data class HomeProfileResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: HomeProfileData
)

//4-1
data class HomeProfileData(
    @SerializedName(value = "userId") var userId: Int,
    @SerializedName(value = "userNickName") var username: String,
    @SerializedName(value = "userMajorName") var department: String,
    @SerializedName(value = "userStudentNum") var studentnum: Long,
    @SerializedName(value = "userBirth") var userBirth: String,
    @SerializedName(value = "userSex") var userSex : String,
    @SerializedName(value = "userSelfIntroduction") var userSelfIntroduction : String,
    @SerializedName(value = "userProfileImg") var userImg: String,
    @SerializedName(value = "userMBTI") var userMBTI : String,
    @SerializedName(value = "userInterest") var userInterest : List<String>,
    @SerializedName(value = "userPersonality") var userPersonality : List<String>,
    @SerializedName(value = "userLikeCount") var likecount: Long,
    @SerializedName(value = "userMatchingCount") var userMatchingCount: Long
    )

package com.example.linkybproject.auth.signup

import com.google.gson.annotations.SerializedName

data class UserSignupReq(
    @SerializedName(value = "authCode") var authCode: String,
    @SerializedName(value = "gradeStatus") var gradeStatus: Boolean,
    @SerializedName(value = "profileImg") var profileImg: String,
    @SerializedName(value = "userBirth") var userBirth: String,
    @SerializedName(value = "userEmail") var userEmail: String,
    @SerializedName(value = "userInterests") var userInterests: ArrayList<String>,
    @SerializedName(value = "userMBTI") var userMBTI: String,
    @SerializedName(value = "userMajorName") var userMajorName: String,
    @SerializedName(value = "userName") var userName: String,
    @SerializedName(value = "userNickName") var userNickName: String,
    @SerializedName(value = "userPassword") var userPassword: String,
    @SerializedName(value = "userPersonalities") var userPersonalities: ArrayList<String>,
    @SerializedName(value = "userSchoolName") var userSchoolName: String,
    @SerializedName(value = "userSelfIntroduction") var userSelfIntroduction: String,
    @SerializedName(value = "userSex") var userSex: String,
    @SerializedName(value = "userStudentNum") var userStudentNum: String
)

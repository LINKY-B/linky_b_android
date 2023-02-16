package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class SignupRequest(
    @SerializedName(value = "profileImg") var profileImg: Int,
    @SerializedName(value = "userName") var userName: String,
    @SerializedName(value = "userNickName") var userNickName: String,
    @SerializedName(value = "userPhone") var userPhone: String,
    @SerializedName(value = "userPassword") var userPassword: String,
    @SerializedName(value = "userBirth") var userBirth: String,
    @SerializedName(value = "userSchoolName") var userSchoolName: String,
    @SerializedName(value = "userMajorName") var userMajorName: String,
    @SerializedName(value = "userMBTI") var userMBTI: String,
    @SerializedName(value = "userStudentNum") var userStudentNum: String,
    @SerializedName(value = "gradeStatus") var gradeStatus: Boolean,
    @SerializedName(value = "userPersonalities") var userPersonalities: ArrayList<String> = arrayListOf(),
    @SerializedName(value = "userInterests") var userInterests: ArrayList<String> = arrayListOf(),
    @SerializedName(value = "userSelfIntroduction") var userSelfIntroduction: String
)

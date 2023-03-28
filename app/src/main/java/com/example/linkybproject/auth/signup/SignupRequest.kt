package com.example.linkybproject.auth.signup

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
    @SerializedName(value = "userSex") var userSex: String,
    @SerializedName(value = "userStudentNum") var userStudentNum: String,
    @SerializedName(value = "gradeStatus") var gradeStatus: Boolean,
    @SerializedName(value = "userPersonalities") var userPersonalities: ArrayList<UserPersonality>,
    @SerializedName(value = "userInterests") var userInterests: ArrayList<UserInterest>,
    @SerializedName(value = "userSelfIntroduction") var userSelfIntroduction: String
)

data class UserInterest(
    @SerializedName(value = "userInterest") var userInterest: String
):java.io.Serializable

data class UserPersonality(
    @SerializedName(value = "userPersonality") var userPersonality: String
):java.io.Serializable

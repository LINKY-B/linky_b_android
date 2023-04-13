package com.example.linkybproject.myprofile.update

import com.google.gson.annotations.SerializedName

data class MyProfileUpdateRequest(
    @SerializedName(value = "userMajorName") var userMajorName: String,
    @SerializedName(value = "userMBTI") var userMBTI: String,
    @SerializedName(value = "userInterests") var userInterests: ArrayList<String>,
    @SerializedName(value = "userPersonalities") var userPersonalities: ArrayList<String>,
    @SerializedName(value = "userSelfIntroduction") var userSelfIntroduction: String,
    @SerializedName(value = "userProfileImg") var userProfileImg: String // 순서 다시 봐야함.
)

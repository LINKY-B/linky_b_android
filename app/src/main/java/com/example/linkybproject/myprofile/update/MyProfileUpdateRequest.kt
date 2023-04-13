package com.example.linkybproject.myprofile.update

import com.google.gson.annotations.SerializedName

data class MyProfileUpdateRequest(
    @SerializedName(value = "profileImg") var profileImg: String,
    @SerializedName(value = "userInterests") var userInterests: ArrayList<String>,
    @SerializedName(value = "userMbti") var userMbti: String,
    @SerializedName(value = "userPersonalities") var userPersonalities: ArrayList<String>,
    @SerializedName(value = "userSelfIntroduction") var userSelfIntroduction: String
)

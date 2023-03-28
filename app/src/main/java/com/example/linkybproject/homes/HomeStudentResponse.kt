package com.example.linkybproject.homes

import com.google.gson.annotations.SerializedName

data class HomeStudentResponse(
    @SerializedName(value = "userNickname") var userimg: String,
    @SerializedName(value = "userMajorName") var department: String,
    @SerializedName(value = "userStudentNum") var studentnum: Long,
    @SerializedName(value = "userProfileImg") var userImg: String,
    @SerializedName(value = "userLikeCount") var likecount: Long,
    @SerializedName(value = "userInterest") var interest : List<Interest>
)
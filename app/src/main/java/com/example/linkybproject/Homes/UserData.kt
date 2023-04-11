package com.example.linkybproject.Homes

import com.google.gson.annotations.SerializedName

data class UserData(
    val userimg : String,
    val username : String,
    val likecount: Int,
    val department :String,
    val studentnum : Int,
    val information :String,
    val contactimg :String,
    val interests :List<Interest>
)

data class Interest(
    @SerializedName("userInterest")val interest:String
)

data class Department(
    val department: String
)

data class Mbti(
    val mbti: String
)


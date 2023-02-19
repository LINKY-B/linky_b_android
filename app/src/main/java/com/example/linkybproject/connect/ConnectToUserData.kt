package com.example.linkybproject.connect

import com.example.linkybproject.homes.Interest

data class ConnectToUserData(
    val userimg : String,
    val username : String,
    val likecount: Int,
    val major :String,
    val classOf :Int,
    val age: Int,
    val gender: String,
    val mbti: String,
    val interests :List<Interest>
)

data class Interest(
    val interest:String
)

data class Department(
    val department: String
)

data class Mbti(
    val mbti: String
)

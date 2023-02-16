package com.example.linkybproject.connect

data class ConnectToUserData(
    val userimg : String,
    val username : String,
    val likecount: Int,
    val major :String,
    val classOf :Int,
    val age: Int,
    val gender: String,
    val mbti: String,
    var interest: ArrayList<String>
)
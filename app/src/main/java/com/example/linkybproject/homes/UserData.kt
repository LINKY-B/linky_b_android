package com.example.linkybproject.homes

data class UserData(
    val userimg : String,
    val username : String,
    val likecount: Int,
    val department :String,
    val information :String,
    val contactimg :String,
    val interests :List<Interest>
)

data class Interest(
    val interest:String
)




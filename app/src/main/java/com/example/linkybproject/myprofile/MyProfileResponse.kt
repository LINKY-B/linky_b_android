package com.example.linkybproject.myprofile

import com.example.linkybproject.connect.LBUser
import com.google.gson.annotations.SerializedName

data class MyProfileResponse(
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: LBUser,
    @SerializedName(value = "errors") val errors: List<MyProfileError>,
)

data class MyProfileError (
    @SerializedName(value = "field") val field: String,
    @SerializedName(value = "value") val value: String,
    @SerializedName(value = "reason") val reason: String,
)
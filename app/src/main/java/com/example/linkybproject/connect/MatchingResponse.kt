package com.example.linkybproject.connect

import com.google.gson.annotations.SerializedName

data class MatchingResponse (
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "data") val data: ArrayList<LBUser>,
)

data class MatchingMainResponse (
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "data") val data: MainResponse,
)

data class MainResponse (
    @SerializedName(value = "나에게 연결을 시도한 회원") val userToMe: ArrayList<LBUser>,
    @SerializedName(value = "내가 연결을 시도한 회원") val userFromMe: ArrayList<LBUser>,
)
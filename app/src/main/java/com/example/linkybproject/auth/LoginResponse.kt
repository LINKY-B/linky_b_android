package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "data") val data: AccessData,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "errors") val errors: List<LoginError>,
)

data class LoginError (
    @SerializedName(value = "field") val field: String,
    @SerializedName(value = "value") val value: String,
    @SerializedName(value = "reason") val reason: String,
)

data class AccessData (
    @SerializedName(value = "type") val type: String,
    @SerializedName(value = "accessToken") val accessToken: String,
)
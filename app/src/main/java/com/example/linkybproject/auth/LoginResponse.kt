package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "data") val data: String,
    @SerializedName(value = "errors") val errors: List<LoginError>,
)

data class LoginError (
    @SerializedName(value = "field") val field: String,
    @SerializedName(value = "value") val value: String,
    @SerializedName(value = "reason") val reason: String,
)
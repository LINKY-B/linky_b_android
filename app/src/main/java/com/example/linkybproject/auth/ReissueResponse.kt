package com.example.linkybproject.auth

import com.google.gson.annotations.SerializedName

data class ReissueResponse(
    @SerializedName(value = "code") val code: String,
    @SerializedName(value = "data") val data: AccessData,
    @SerializedName(value = "message") val message: String,
    @SerializedName(value = "status") val status: Int,
    @SerializedName(value = "errors") val errors: List<ReissueError>,
)

data class ReissueError (
    @SerializedName(value = "field") val field: String,
    @SerializedName(value = "value") val value: String,
    @SerializedName(value = "reason") val reason: String,
)

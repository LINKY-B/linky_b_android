package com.example.linkybproject.chat

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ChatRoomListResponse(
    @SerializedName("isSuccess") val isSuccess: Boolean,
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String,
    @SerializedName("result") val result: List<ChatRoom>
)

data class ChatRoom (
    @SerializedName("userChattingRoomIdx") val userChattingRoomIdx: Int,
    @SerializedName("userIdx") val userIdx: Int,
    @SerializedName("userNickname") val userNickname: String,
    @SerializedName("userMajorName") val userMajorName: String,
    @SerializedName("userStudentNum") val userStudentNum: String,
    @SerializedName("userProfilePicture") val userProfilePicture: String,
    @SerializedName("lastConversationContents") val lastConversationContents: String,
    @SerializedName("lastConversationTime") val lastConversationTime: String
) : Serializable

package com.example.linkybproject.myprofile

interface NoticeOnView {
    fun onNoticeSuccess(turnOnTheNotice: NoticeResponse)
    fun onNoticeFailure()
}
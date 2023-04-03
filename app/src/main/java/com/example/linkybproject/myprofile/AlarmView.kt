package com.example.linkybproject.myprofile

interface AlarmView {
    fun onAlarmSuccess(turnOnTheNotice: AlarmResponse)
    fun onAlarmFailure()
}
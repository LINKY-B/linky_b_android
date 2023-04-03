package com.example.linkybproject.myprofile

interface ActiveView {
    fun onActiveSuccess(turnOnTheInfo: ActiveResponse)
    fun onActiveFailure()
}
package com.example.linkybproject.connect

interface ConnectToMeView {
    fun onConnectToMeSuccess(connectToMeList: MatchingResponse)
    fun onConnectToMeFailure()
}
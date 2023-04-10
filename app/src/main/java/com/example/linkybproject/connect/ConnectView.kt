package com.example.linkybproject.connect

interface ConnectView {
    fun onConnectSuccess(response: MatchingResponse)
    fun onConnectFailure()
}
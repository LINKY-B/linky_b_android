package com.example.linkybproject.connect

interface MatchingMainView {
    fun onMatchingMainSuccess(response: MatchingMainResponse)
    fun onMatchingMainFailure()
}
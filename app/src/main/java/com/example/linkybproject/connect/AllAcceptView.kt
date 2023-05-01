package com.example.linkybproject.connect

interface AllAcceptView {
    fun onAllMatchingSuccess(matchingAll: AllMatchingResponse)
    fun onAllMatchingFailure()
}
package com.example.linkybproject.connect

interface AllMatchingView {
    fun onAllMatchingSuccess(matchingAll: AllMatchingResponse)
    fun onAllMatchingFailure()
}
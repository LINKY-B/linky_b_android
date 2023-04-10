package com.example.linkybproject.auth

interface ReissueView {
    fun onReissueSuccess(result: ReissueResponse)
    fun onReissueFailure()
}
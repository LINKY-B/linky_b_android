package com.example.linkybproject.myprofile

interface MyProfileView {
    fun onGetUserSuccess(result: MyProfileResponse)
    fun onGetUserFailure()
}
package com.example.linkybproject.auth.signup

interface ProfileImagesView {
    fun onProfileImagesSuccess(data: ArrayList<String>)
    fun onProfileImagesFailure()
}
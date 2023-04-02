package com.example.linkybproject.auth

interface LoginView {
    fun onLoginSuccess(result: LoginResponse)
    fun onLoginFailure()
}
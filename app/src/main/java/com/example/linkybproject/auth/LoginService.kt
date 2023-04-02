package com.example.linkybproject.auth

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService {
    private lateinit var loginView: LoginView

    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
    }

    fun login(loginRequest: LoginRequest) {
        val loginService = getRetrofit().create(LoginRetrofitInterface::class.java)

        loginService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.d("Login(Success)", response.toString())
                val resp: LoginResponse = response.body()!!

                when(resp.status) {
                    200 -> loginView.onLoginSuccess()
                    else -> loginView.onLoginFailure()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("Login(Failure)", t.message.toString())
            }

        })
    }
}
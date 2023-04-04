package com.example.linkybproject.auth.signup

import android.annotation.SuppressLint
import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailAuthService {

    private lateinit var emailAuthView: EmailAuthView

    fun setEmailAuthView(emailAuthView: EmailAuthView) {
        this.emailAuthView = emailAuthView
    }

    fun emailAuth(emailAuthRequest: EmailAuthRequest) {
        val emailAuthService = getRetrofit().create(SignupRetrofitInterface::class.java)

        emailAuthService.emailAuth(emailAuthRequest).enqueue(object: Callback<EmailAuthResponse> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(
                call: Call<EmailAuthResponse>,
                response: Response<EmailAuthResponse>
            ) {
                Log.d("EMAIL/SUCCESS", response.message().toString())
                val res: EmailAuthResponse = response.body()!!
                if (res.status == 200) {
                    emailAuthView.onEmailAuthSuccess()
                } else {
                    emailAuthView.onEmailAuthFailure()
                }
            }

            override fun onFailure(call: Call<EmailAuthResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.message.toString())
            }
        })
    }
}
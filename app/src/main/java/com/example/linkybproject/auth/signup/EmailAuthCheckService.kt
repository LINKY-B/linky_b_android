package com.example.linkybproject.auth.signup

import android.util.Log
import com.example.linkybproject.getRetrofit
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmailAuthCheckService {

    private lateinit var emailAuthCheckView: EmailAuthCheckView

    fun setEmailAuthCheckView(emailAuthCheckView: EmailAuthCheckView) {
        this.emailAuthCheckView = emailAuthCheckView
    }

    fun emailAuthCheck(emailAuthCheckRequest: EmailAuthCheckRequest) {
        val emailAuthCheckService = getRetrofit().create(SignupRetrofitInterface::class.java)

        emailAuthCheckService.emailAuthCheck(emailAuthCheckRequest)
            .enqueue(object : Callback<EmailAuthCheckResponse> {
                override fun onResponse(
                    call: Call<EmailAuthCheckResponse>,
                    response: Response<EmailAuthCheckResponse>
                ) {
                    Log.d("AUTH/SUCCESS", response.toString())
                    val res: EmailAuthCheckResponse = response.body()!!
                    when (res.status) {
                        200 -> emailAuthCheckView.onEmailAuthCheckSuccess()
                        else -> emailAuthCheckView.onEmailAuthCheckFailure()
                    }
                }

                override fun onFailure(call: Call<EmailAuthCheckResponse>, t: Throwable) {
                    Log.d("AUTH/FAILURE", t.message.toString())
                }

            })
    }
}
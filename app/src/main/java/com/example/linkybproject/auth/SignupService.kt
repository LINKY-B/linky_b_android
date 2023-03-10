package com.example.linkybproject.auth

import android.annotation.SuppressLint
import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupService {

    // 1단계. View를 연결해준다
    private lateinit var signupView: SignupView

    fun setSignUpView(signupView: SignupView) {
        this.signupView = signupView
    }

    // 2단계. Retrofit 관련 작업을 해 줄 함수를 만든다.
    fun signup(signupRequest: SignupRequest) {
        val signupService = getRetrofit().create(SignupRetrofitInterface::class.java)

        signupService.signup(signupRequest).enqueue(object: Callback<SignupResponse> {
            @SuppressLint("SuspiciousIndentation")
            override fun onResponse(call: Call<SignupResponse>, response: Response<SignupResponse>) {
                Log.d("SIGNUP/SUCCESS", response.toString())
                val resp: SignupResponse = response.body()!!

//                Log.d("SIGNUP/SUCCESS/PHONE", resp.phone.toString())
//                if(resp.phone) {
                    signupView.onSignupSuccess()
//                    1000 ->  signupView.onSignupSuccess()
//                    else -> signupView.onSignupFailure()
//                }
            }

            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.message.toString())
            }
        })
    }

}
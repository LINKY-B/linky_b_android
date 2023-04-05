package com.example.linkybproject.auth.signup

import android.util.Log
import com.example.linkybproject.getRetrofit
import okhttp3.MultipartBody
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
    fun signup(userSignupReq: UserSignupReq, schoolImg: MultipartBody.Part) {
        val signupService = getRetrofit().create(SignupRetrofitInterface::class.java)

        signupService.signup(userSignupReq, schoolImg).enqueue(object: Callback<SignupResponse> {
            override fun onResponse(call: Call<SignupResponse>, response: Response<SignupResponse>) {
                Log.d("SIGNUP/SUCCESS", response.toString())
                val res: SignupResponse = response.body()!!
                when(res.status) {
                    200 ->  signupView.onSignupSuccess()
                    else -> signupView.onSignupFailure()
                }
            }

            override fun onFailure(call: Call<SignupResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.message.toString())
            }
        })
    }

}
package com.example.linkybproject.auth

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthService {
    private lateinit var loginView: LoginView
    private lateinit var reissueView: ReissueView

    fun setLoginView(loginView: LoginView) {
        this.loginView = loginView
    }

    fun setReissueView(reissueView: ReissueView) {
        this.reissueView = reissueView
    }

    fun login(loginRequest: LoginRequest) {
        val authService = getRetrofit().create(LoginRetrofitInterface::class.java)

        authService.login(loginRequest).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                Log.d("Login(Success)", response.toString())
                val resp: LoginResponse = response.body()!!

                when (resp.status) {
                    200 -> loginView.onLoginSuccess(resp)
                    else -> loginView.onLoginFailure()
                }
            }

            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                Log.d("Login(Failure)", t.message.toString())
            }
        })
    }

    fun reissue(token: String) {
        val authService = getRetrofit().create(LoginRetrofitInterface::class.java)

       authService.reissue(token).enqueue(object: Callback<ReissueResponse> {
           override fun onResponse(call: Call<ReissueResponse>, response: Response<ReissueResponse>) {
               Log.d("Reissue (Success)", response.toString())
               val resp: ReissueResponse = response.body()!!

               when (resp.status) {
                   200 -> reissueView.onReissueSuccess(resp)
                   else -> reissueView.onReissueFailure()
               }
           }

           override fun onFailure(call: Call<ReissueResponse>, t: Throwable) {
               Log.d("Reissue (Fail)", t.message.toString())
           }
       })
    }
}
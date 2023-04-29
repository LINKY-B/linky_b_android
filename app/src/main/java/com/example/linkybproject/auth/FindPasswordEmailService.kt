package com.example.linkybproject.auth

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindPasswordEmailService {

    private lateinit var findPasswordEmailView : FindPasswordEmailView

    fun setFindPasswordEmailView(findPasswordEmailView: FindPasswordEmailView) {
        this.findPasswordEmailView = findPasswordEmailView
    }

    fun getEmail(findPasswordEmailRequest : FindPasswordEmailRequest) {
        val findPasswordEmailService = getRetrofit().create(LoginRetrofitInterface::class.java)

        findPasswordEmailService.getEmail(findPasswordEmailRequest).enqueue(object: Callback<FindPasswordEmailResponse> {
            override fun onResponse(call: Call<FindPasswordEmailResponse>, response: Response<FindPasswordEmailResponse>) {
                Log.d("GET_EMAIL/SUCCESS", response.toString())
                val res: FindPasswordEmailResponse = response.body()!!
                when(res.status){
                  200 -> findPasswordEmailView.onFindPasswordEmailViewSuccess()
                  else -> findPasswordEmailView.onFindPasswordEmailViewFailure()
                }
            }

            override fun onFailure(call: Call<FindPasswordEmailResponse>, t: Throwable) {
                Log.d("GET_EMAIL/FAILURE", t.message.toString())
            }

        })
    }
}
package com.example.linkybproject.auth

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FindPasswordService {

    private lateinit var findPasswordView: FindPasswordView

    fun setFindPasswordView(findPasswordView: FindPasswordView) {
        this.findPasswordView = findPasswordView
    }

    fun changePW(findPasswordRequest: FindPasswordRequest) {
        val findPasswordService = getRetrofit().create(LoginRetrofitInterface::class.java)

        findPasswordService.changePW(findPasswordRequest).enqueue(object: Callback<FindPasswordResponse> {
            override fun onResponse(call: Call<FindPasswordResponse>, response: Response<FindPasswordResponse>) {
                Log.d("CHANGE_PW_SUCCESS", response.toString())
                val res: FindPasswordResponse = response.body()!!
                when(res.status){
                  200 -> findPasswordView.onFindPasswordSuccess()
                  else -> findPasswordView.onFindPasswordFailure()
                }
            }

            override fun onFailure(call: Call<FindPasswordResponse>, t: Throwable) {
                Log.d("CHANGE_PW_SUCCESS", t.message.toString())
            }

        })
    }
}
package com.example.linkybproject.auth.signup

import android.annotation.SuppressLint
import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NicknameService {

    private lateinit var nicknameView: NicknameView

    fun setNicknameView(nicknameView: NicknameView) {
        this.nicknameView = nicknameView
    }

    fun nickName(nicknameRequest: NicknameRequest) {
        val nicknameService = getRetrofit().create(SignupRetrofitInterface::class.java)

        nicknameService.nickName(nicknameRequest).enqueue(object: Callback<NicknameResponse> {
            override fun onResponse(call: Call<NicknameResponse>, response: Response<NicknameResponse>) {
                Log.d("NICK/SUCCESS", response.toString())
                val res: NicknameResponse = response.body()!!
                when(res.status) {
                    200 -> nicknameView.onNicknameSuccess()
                    else -> nicknameView.onNicknameFailure()
                }
            }

            override fun onFailure(call: Call<NicknameResponse>, t: Throwable) {
                Log.d("NICK/FAILURE", t.message.toString())
            }

        })
    }

}
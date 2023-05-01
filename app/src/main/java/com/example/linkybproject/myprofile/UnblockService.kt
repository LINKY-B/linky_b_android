package com.example.linkybproject.myprofile

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Response

class UnblockService {
    private lateinit var unblockView: UnblockView

    fun setUnblockView(unblockView: UnblockDialog) {
        this.unblockView = unblockView
    }

    fun unblock(token: String, unblockRequest: UnblockRequest) {
        val unblockService = getRetrofit().create(UnblockInterface::class.java)

        unblockService.unblock("Bearer $token", unblockRequest).enqueue(object : retrofit2.Callback<UnblockResponse> {
            override fun onResponse(call: Call<UnblockResponse>, response: Response<UnblockResponse>) {
                Log.d("test", response.toString())
                val res: UnblockResponse = response.body()!!

                if (res != null) {
                    when (res.status) {
                        200 -> unblockView.onUnblockSuccess()
                        else -> unblockView.onUnblockFailure()
                    }
                } else {
                    if (res != null) {
                        unblockView.onUnblockFailure()
                    }
                }
            }

            override fun onFailure(call: Call<UnblockResponse>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }
}
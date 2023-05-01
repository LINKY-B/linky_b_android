package com.example.linkybproject.connect

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Response

class AllAcceptService {
    private lateinit var allAcceptView: AllAcceptView

    fun setAllMatchingView(allMatchingView: AllAcceptDialog) {
        this.allAcceptView = allMatchingView
    }

    fun matchingAll(token: String, userGetMatched: String) {
        val allMatchingService = getRetrofit().create(AllAcceptInterface::class.java)
        allMatchingService.matchingAll(token).enqueue(object : retrofit2.Callback<AllMatchingResponse> {
            override fun onResponse(call: Call<AllMatchingResponse>, response: Response<AllMatchingResponse>) {
                Log.d("test", response.toString())

                val resp: AllMatchingResponse? = response.body()
                if (resp != null) {
                    when (resp.status) {
                        200 -> {
                            allAcceptView.onAllMatchingSuccess(resp)
                            Log.d("test", resp.toString())
                        }
                        else -> allAcceptView.onAllMatchingFailure()
                    }
                } else {
                    allAcceptView.onAllMatchingFailure()
                }
            }

            override fun onFailure(call: Call<AllMatchingResponse>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

}
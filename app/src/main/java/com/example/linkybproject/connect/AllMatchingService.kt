package com.example.linkybproject.connect

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Response

class AllMatchingService {
    private lateinit var allMatchingView: AllMatchingView

    fun setAllMatchingView(allMatchingView: AllAcceptDialog) {
        this.allMatchingView = allMatchingView
    }

    fun matchingAll(token: String, userGetMatched: String) {
        val allMatchingService = getRetrofit().create(AllMatchingInterface::class.java)
        allMatchingService.matchingAll(token).enqueue(object : retrofit2.Callback<AllMatchingResponse> {
            override fun onResponse(call: Call<AllMatchingResponse>, response: Response<AllMatchingResponse>) {
                Log.d("test", response.toString())

                val resp: AllMatchingResponse? = response.body()
                if (resp != null) {
                    when (resp.status) {
                        200 -> {
                            allMatchingView.onAllMatchingSuccess(resp)
                            Log.d("test", resp.toString())
                        }
                        else -> allMatchingView.onAllMatchingFailure()
                    }
                } else {
                    allMatchingView.onAllMatchingFailure()
                }
            }

            override fun onFailure(call: Call<AllMatchingResponse>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

}
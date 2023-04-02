package com.example.linkybproject.connect

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConnectService {
    private lateinit var connectToMeView: ConnectToMeView

    fun setConnectToMeView(connectToMeView: ConnectToMeView) {
        this.connectToMeView = connectToMeView
    }

    fun connectToMeList(token: String) {
        val connectService = getRetrofit().create(ConnectInterface::class.java)
        connectService.connectToMeList("Bearer $token").enqueue(object: Callback<MatchingResponse> {
            override fun onResponse(call: Call<MatchingResponse>, response: Response<MatchingResponse>) {
                Log.d("connectToMeList", response.toString())

                val resp: MatchingResponse? = response.body()

                if (resp != null) {
                    when(resp.code) {
                        1000 -> connectToMeView.onConnectToMeSuccess(resp)
                        else -> connectToMeView.onConnectToMeFailure()
                    }
                } else {
                    connectToMeView.onConnectToMeFailure()
                }
            }

            override fun onFailure(call: Call<MatchingResponse>, t: Throwable) {
                Log.d("connectToMeList", t.message.toString())
            }
        })
    }
}
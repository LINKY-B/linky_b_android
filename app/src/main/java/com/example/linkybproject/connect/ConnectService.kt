package com.example.linkybproject.connect

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ConnectService {
    private lateinit var connectView: ConnectView
    private lateinit var matchingMainView: MatchingMainView

    fun setConnectToMeView(connectToMeView: ConnectView) {
        this.connectView = connectToMeView
    }

    fun setConnectFromMeView(connectFromMeView: ConnectView) {
        this.connectView = connectFromMeView
    }

    fun setConnectMainView(matchingMainView: MatchingMainView) {
        this.matchingMainView = matchingMainView
    }

    fun connectToMeList(token: String) {
        val connectService = getRetrofit().create(ConnectInterface::class.java)
        connectService.connectToMeList("Bearer $token").enqueue(object: Callback<MatchingResponse> {
            override fun onResponse(call: Call<MatchingResponse>, response: Response<MatchingResponse>) {
                Log.d("connectToMeList", response.toString())

                val resp: MatchingResponse? = response.body()

                if (resp != null) {
                    when(resp.status) {
                        200 -> connectView.onConnectSuccess(resp)
                        else -> connectView.onConnectFailure()
                    }
                } else {
                    connectView.onConnectFailure()
                }
            }

            override fun onFailure(call: Call<MatchingResponse>, t: Throwable) {
                Log.d("connectToMeList", t.message.toString())
            }
        })
    }

    fun connectFromMeList(token: String) {
        val connectService = getRetrofit().create(ConnectInterface::class.java)
        connectService.connectFromMeList("Bearer $token").enqueue(object: Callback<MatchingResponse> {
            override fun onResponse(call: Call<MatchingResponse>, response: Response<MatchingResponse>) {
                Log.d("connectFromMeList", response.toString())

                val resp: MatchingResponse? = response.body()

                if (resp != null) {
                    when(resp.status) {
                        200 -> connectView.onConnectSuccess(resp)
                        else -> connectView.onConnectFailure()
                    }
                } else {
                    connectView.onConnectFailure()
                }
            }

            override fun onFailure(call: Call<MatchingResponse>, t: Throwable) {
                Log.d("connectFromMeList", t.message.toString())
            }
        })
    }

    fun connectMainList(token: String) {
        val connectService = getRetrofit().create(ConnectInterface::class.java)
        connectService.connectMainList("Bearer $token").enqueue(object: Callback<MatchingMainResponse> {
            override fun onResponse(call: Call<MatchingMainResponse>, response: Response<MatchingMainResponse>) {
                Log.d("connectMainList", response.toString())

                val resp: MatchingMainResponse? = response.body()

                if (resp != null) {
                    when(resp.status) {
                        200 -> matchingMainView.onMatchingMainSuccess(resp)
                        else -> matchingMainView.onMatchingMainFailure()
                    }
                } else {
                    matchingMainView.onMatchingMainFailure()
                }
            }

            override fun onFailure(call: Call<MatchingMainResponse>, t: Throwable) {
                Log.d("connectMainList [fail]", t.message.toString())
            }
        })
    }
}
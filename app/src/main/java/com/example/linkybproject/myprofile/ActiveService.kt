package com.example.linkybproject.myprofile

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback
import kotlin.math.log

class ActiveService {
    private lateinit var activeView: ActiveView

    fun setActiveView(activeView: ActiveView) {
        this.activeView = activeView
    }

    fun turnOnTheInfo(token: String) {
        val activeService = getRetrofit().create(ActiveInterface::class.java)
        activeService.turnOnTheInfo(token).enqueue(object : retrofit2.Callback<ActiveResponse> {
            override fun onResponse(call: Call<ActiveResponse>, response: Response<ActiveResponse>) {
                Log.d("test", response.toString())

                val resp: ActiveResponse? = response.body()
                if (resp != null) {
                    when (resp.status) {
                        200 -> {
                            activeView.onActiveSuccess(resp)
                            Log.d("test", resp.toString())
                        }
                        else -> activeView.onActiveFailure()
                    }
                } else {
                    activeView.onActiveFailure()
                }
            }

            override fun onFailure(call: Call<ActiveResponse>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

    fun turnOffTheInfo(token: String) {
        val activeService = getRetrofit().create(ActiveInterface::class.java)
        activeService.turnOffTheInfo(token).enqueue(object : retrofit2.Callback<ActiveResponse> {
            override fun onResponse(call: Call<ActiveResponse>, response: Response<ActiveResponse>) {
                Log.d("test", response.toString())

                val resp: ActiveResponse = response.body()!!
                if (resp != null) {
                    when (resp.status) {
                        200 -> {
                            activeView.onActiveSuccess(resp)
                            Log.d("test", resp.toString())
                        }
                        else -> activeView.onActiveFailure()
                    }
                } else {
                    activeView.onActiveFailure()
                }
            }

            override fun onFailure(call: Call<ActiveResponse>, t: Throwable) {
                Log.d("test", t.message.toString())
            }
        })
    }

}
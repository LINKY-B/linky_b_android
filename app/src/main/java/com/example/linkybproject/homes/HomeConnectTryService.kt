package com.example.linkybproject.homes

import android.annotation.SuppressLint
import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeConnectTryService {

    // 1단계 : View를 연결해준다
    private lateinit var homeConnectTryView: HomeConnectTryView

    fun setHomeConnectTryView(homeConnectTryView:  HomeConnectTryView) {
        this.homeConnectTryView = homeConnectTryView
    }

    // 2단계 : Retrofit 관련 작업을 해 줄 함수를 만든다.
    @SuppressLint("SuspiciousIndentation")
    fun homeConnectTry(token: String, userGetMatched: String) {
        val homeConnectTryService = getRetrofit().create(HomeConnectTryInterface::class.java)
        homeConnectTryService.homeConnectTry("Bearer ${token}", userGetMatched)
            .enqueue(object : Callback<HomeConnectResponse> {
                override fun onResponse(
                    call: Call<HomeConnectResponse>,
                    response: Response<HomeConnectResponse>
                ) {

                    Log.d("homeConnectTry", call.toString())

                    val resp: HomeConnectResponse? = response.body()

                    if (resp != null) {
                        when (resp.status) {
                            200 -> homeConnectTryView.onHomeConnectTrySuccess(resp)
                            else -> homeConnectTryView.onGetHomeConnectTryFailure()
                        }
                    }
                }

                override fun onFailure(call: Call<HomeConnectResponse>, t: Throwable) {
                    Log.d("homeConnectTry", t.message.toString())
                }
            })

    }
}











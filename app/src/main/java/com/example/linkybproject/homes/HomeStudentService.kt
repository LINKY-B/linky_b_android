package com.example.linkybproject.homes

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeStudentService {
        // 1단계
        private lateinit var getHomeStudentView: GetHomeStudentView

        fun setHomeStudentView(getHomeStudentView: GetHomeStudentView) {
            this.getHomeStudentView = getHomeStudentView
        }

        // 2단계
        fun getHomeStudent(homeStudentRequest: HomeStudentRequest) {
            val authService = getRetrofit().create(HomeStudentRetrofitInterface::class.java)

            authService.getHomeStudent(homeStudentRequest).enqueue(object :
                Callback<HomeStudentResponse> {
                override fun onResponse(
                    call: Call<HomeStudentResponse>,
                    response: Response<HomeStudentResponse>
                ) {
                    Log.d("SIGNUP/SUCCESS", response.toString())
                    val resp: HomeStudentResponse = response.body()!!

//                    when (resp.code) {
//                        1000 -> getHomeStudentView.onGetHomeStudentSuccess()
//                        else -> getHomeStudentView.onGetHomeStudentFailure()
//                    }
                }

                override fun onFailure(call: Call<HomeStudentResponse>, t: Throwable) {
                    Log.d("SIGNUP/FAILURE", t.message.toString())
                }
            })
        }
    }

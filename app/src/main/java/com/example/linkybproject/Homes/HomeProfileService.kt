package com.example.linkybproject.Homes

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeProfileService {
    private lateinit var homeProfileView: HomeProfileView

    fun setHomeProfileView(homeProfileView: HomeProfileView) {
        this.homeProfileView = homeProfileView
    }

    // 2단계 : Retrofit 관련 작업을 해 줄 함수를 만든다.
    fun homeProfile(token: String) {
        val homeProfileService = getRetrofit().create(HomeProfileInterface::class.java)
            homeProfileService.homeProfile("Bearer ${token}")
                .enqueue(object : Callback<HomeProfileResponse> {
                    override fun onResponse(
                        call: Call<HomeProfileResponse>,
                        response: Response<HomeProfileResponse>
                    ) {

                        val resp: HomeProfileResponse = response.body()!!
                            when (resp.status) {
                                200 -> homeProfileView.onHomeProfileSuccess(resp)
                                else -> homeProfileView.onGetHomeProfileFailure()
                            }
                        }

                    override fun onFailure(call: Call<HomeProfileResponse>, t: Throwable) {
                        Log.d("homeprofile", t.message.toString())
                    }
                })

        }
    }


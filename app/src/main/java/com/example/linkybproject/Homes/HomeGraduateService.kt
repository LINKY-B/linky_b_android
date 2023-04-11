package com.example.linkybproject.Homes

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeGraduateService {

    // 1단계 : View를 연결해준다

    private lateinit var homeGraduateView: HomeGraduateView

    fun setHomeGraduateView(homeGraduateView: HomeGraduateView) {
        this.homeGraduateView = homeGraduateView
    }

    // 2단계 : Retrofit 관련 작업을 해 줄 함수를 만든다.
    fun homeGraduate(token: String) {
        val homeGraduateService = getRetrofit().create(HomeGraudateInterface::class.java)
        try {
            homeGraduateService.homeGraduate("Bearer ${token}")
                .enqueue(object : Callback<HomeGraduateResponse> {
                    override fun onResponse(
                        call: Call<HomeGraduateResponse>,
                        response: Response<HomeGraduateResponse>
                    ) {

                        val resp: HomeGraduateResponse? = response.body()

                        if (resp != null) {
                            when (resp.status) {
                                200 -> homeGraduateView.onHomeGraduateListSuccess(resp)
                                else -> homeGraduateView.onGetHomeGraduateListFailure()
                            }
                        }
                    }

                    override fun onFailure(call: Call<HomeGraduateResponse>, t: Throwable) {
                        Log.d("homeStudentList", t.message.toString())
                    }
                })
        } catch (e: java.lang.IllegalStateException) {
            Log.e("test",e.toString());
        }
    }
}


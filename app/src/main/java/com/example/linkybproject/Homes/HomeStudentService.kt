package com.example.linkybproject.Homes

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeStudentService {
        // 1단계 : View를 연결해준다

        private lateinit var homeStudentView: HomeStudentView

        fun setHomeStudentView(homeStudentView: HomeStudentView) {
            this.homeStudentView = homeStudentView
        }

        // 2단계 : Retrofit 관련 작업을 해 줄 함수를 만든다.
        fun homeStudent(token: String) {
            val homeStudentService = getRetrofit().create(HomeStudentInterface::class.java)
            try {
                homeStudentService.homeStudent("Bearer ${token}")
                    .enqueue(object : Callback<HomeStudentResponse> {
                        override fun onResponse(
                            call: Call<HomeStudentResponse>,
                            response: Response<HomeStudentResponse>
                        ) {

                            val resp: HomeStudentResponse? = response.body()

                            if (resp != null) {
                                when (resp.status) {
                                    200 -> homeStudentView.onHomeStudentListSuccess(resp)
                                    else -> homeStudentView.onGetHomeStudentListFailure()
                                }
                            }
                        }

                        override fun onFailure(call: Call<HomeStudentResponse>, t: Throwable) {
                            Log.d("homeStudentList", t.message.toString())
                        }
                    })
            } catch (e: java.lang.IllegalStateException) {
                Log.e("test",e.toString());
            }
        }
    }

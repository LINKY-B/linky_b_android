package com.example.linkybproject.myprofile

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeService {
    private lateinit var noticeOnView: NoticeOnView

    fun setNoticeView(noticeOnView: NoticeOnView) {
        this.noticeOnView = noticeOnView
    }

    fun turnOnTheNotice(token: String) {
        val noticeService = getRetrofit().create(NoticeOnInterface::class.java)
        noticeService.turnOnTheNotice(token).enqueue(object : Callback<NoticeResponse> {
            override fun onResponse(call: Call<NoticeResponse>, response: Response<NoticeResponse>) {
                Log.d("Test", response.toString())

                val resp: NoticeResponse? = response.body()

                if (resp != null) {
                    when(resp.status) {
                        200 -> {
                            noticeOnView.onNoticeSuccess(resp)
                            Log.d("Test",resp.toString())
                        }
                        else -> noticeOnView.onNoticeFailure()
                    }
                }
                else {
                    noticeOnView.onNoticeFailure()
                }
            }

            override fun onFailure(call: Call<NoticeResponse>, t: Throwable) {
                Log.d("Test", t.message.toString())
            }
        })
    }

    fun turnOffTheNotice(token: String) {
        val noticeService = getRetrofit().create(NoticeOnInterface::class.java)
        noticeService.turnOffTheNotice(token).enqueue(object : Callback<NoticeResponse> {
            override fun onResponse(call: Call<NoticeResponse>, response: Response<NoticeResponse>) {
                Log.d("Test", response.toString())

                val resp: NoticeResponse? = response.body()

                if (resp != null) {
                    when(resp.status) {
                        200 -> {
                            noticeOnView.onNoticeSuccess(resp)
                            Log.d("Test",resp.toString())
                        }
                        else -> noticeOnView.onNoticeFailure()
                    }
                }
                else {
                    noticeOnView.onNoticeFailure()
                }
            }

            override fun onFailure(call: Call<NoticeResponse>, t: Throwable) {
                Log.d("Test", t.message.toString())
            }
        })
    }
}
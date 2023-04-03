package com.example.linkybproject.myprofile

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlarmService {
    private lateinit var alarmView: AlarmView

    fun setAlarmView(alarmView: AlarmView) {
        this.alarmView = alarmView
    }

    fun turnOnTheNotice(token: String) {
        val noticeService = getRetrofit().create(AlarmInterface::class.java)
        noticeService.turnOnTheNotice(token).enqueue(object : Callback<AlarmResponse> {
            override fun onResponse(call: Call<AlarmResponse>, response: Response<AlarmResponse>) {
                Log.d("Test", response.toString())

                val resp: AlarmResponse? = response.body()
                if (resp != null) {
                    when (resp.status) {
                        200 -> {
                            alarmView.onAlarmSuccess(resp)
                            Log.d("Test",resp.toString())
                        }
                        else -> alarmView.onAlarmFailure()
                    }
                } else {
                    alarmView.onAlarmFailure()
                }
            }

            override fun onFailure(call: Call<AlarmResponse>, t: Throwable) {
                Log.d("Test", t.message.toString())
            }
        })
    }

    fun turnOffTheNotice(token: String) {
        val noticeService = getRetrofit().create(AlarmInterface::class.java)
        noticeService.turnOffTheNotice(token).enqueue(object : Callback<AlarmResponse> {
            override fun onResponse(call: Call<AlarmResponse>, response: Response<AlarmResponse>) {
                Log.d("Test", response.toString())

                val resp: AlarmResponse? = response.body()
                if (resp != null) {
                    when(resp.status) {
                        200 -> {
                            alarmView.onAlarmSuccess(resp)
                            Log.d("Test",resp.toString())
                        }
                        else -> alarmView.onAlarmFailure()
                    }
                }
                else {
                    alarmView.onAlarmFailure()
                }
            }

            override fun onFailure(call: Call<AlarmResponse>, t: Throwable) {
                Log.d("Test", t.message.toString())
            }
        })
    }
}
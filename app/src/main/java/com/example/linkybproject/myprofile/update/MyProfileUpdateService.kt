package com.example.linkybproject.myprofile.update

import android.util.Log
import com.example.linkybproject.getRetrofit
import com.example.linkybproject.myprofile.MyProfileInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileUpdateService {
    private lateinit var myProfileUpdateView: MyProfileUpdateView

    fun setView(myProfileUpdateView: MyProfileUpdateView) {
        this.myProfileUpdateView = myProfileUpdateView
    }

    fun updateMyProfile(myProfileUpdateRequest: MyProfileUpdateRequest) {
        val myProfileUpdateService = getRetrofit().create(MyProfileInterface::class.java)

        myProfileUpdateService.updateMyProfile(myProfileUpdateRequest).enqueue(object : Callback<MyProfileUpdateResponse> {
            override fun onResponse(call: Call<MyProfileUpdateResponse>, response: Response<MyProfileUpdateResponse>
            ) {
                Log.d("SIGNUP/SUCCESS", response.toString())
                val res: MyProfileUpdateResponse = response.body()!!

                when(res.status){
                  200 -> myProfileUpdateView.onSignupSuccess()
                  else -> myProfileUpdateView.onSignupFailure()
                }
            }

            override fun onFailure(call: Call<MyProfileUpdateResponse>, t: Throwable) {
                Log.d("SIGNUP/FAILURE", t.message.toString())
            }

        })
    }
}
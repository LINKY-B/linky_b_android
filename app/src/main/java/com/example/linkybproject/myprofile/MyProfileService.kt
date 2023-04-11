package com.example.linkybproject.myprofile

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyProfileService {
    private lateinit var myProfileView: MyProfileView

    fun setMyProfileView(myProfileView: MyProfileView) {
        this.myProfileView = myProfileView
    }

    fun getUser(token: String) {
        val profileService = getRetrofit().create(MyProfileInterface::class.java)
        profileService.getUser("Bearer $token").enqueue(object: Callback<MyProfileResponse> {
            override fun onResponse(call: Call<MyProfileResponse>, response: Response<MyProfileResponse>) {
                Log.d("getUser", response.toString())

                val resp: MyProfileResponse? = response.body()

                if (resp != null) {
                    when(resp.status) {
                        200 -> myProfileView.onGetUserSuccess(resp)
                        else -> myProfileView.onGetUserFailure()
                    }
                } else {
                    if (resp != null) {
                        myProfileView.onGetUserFailure()
                    }
                }
            }

            override fun onFailure(call: Call<MyProfileResponse>, t: Throwable) {
                Log.d("getUser (Fail)", t.message.toString())
            }
        })
    }
}
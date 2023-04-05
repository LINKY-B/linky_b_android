package com.example.linkybproject.auth.signup

import android.util.Log
import com.example.linkybproject.getRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileImagesService {

    private lateinit var profileImagesView: ProfileImagesView

    fun setProfileImagesView(profileImagesView: ProfileImagesView) {
        this.profileImagesView = profileImagesView
    }

    fun getProfileImages() {
        val profileImagesService = getRetrofit().create(SignupRetrofitInterface::class.java)

        profileImagesService.getProfileImages().enqueue(object: Callback<ProfileImagesResponse> {
            override fun onResponse(call: Call<ProfileImagesResponse>, response: Response<ProfileImagesResponse>) {
                Log.d("PROFILE/SUCCESS", response.toString())
                val res: ProfileImagesResponse = response.body()!!
                when(res.status) {
                    200 -> profileImagesView.onProfileImagesSuccess(res.data)
                    else -> profileImagesView.onProfileImagesFailure()
                }
            }

            override fun onFailure(call: Call<ProfileImagesResponse>, t: Throwable) {
                Log.d("PROFILE/FAILURE", t.message.toString())
            }

        })
    }
}
package com.example.linkybproject.homes

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface HomeStudentRetrofitInterface {
    @GET("/users") // @Method(api address)
    fun getHomeStudent(@Body homeStudentRequest: HomeStudentRequest): Call<HomeStudentResponse>
}
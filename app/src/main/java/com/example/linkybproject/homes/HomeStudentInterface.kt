package com.example.linkybproject.homes

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header


interface HomeStudentInterface {
    // 1.재학생, 졸업생 리스트 조회
    @GET("/home/all") // @Method(api address)
    fun homeStudent(
        @Header("Authorization") token: String
    ): Call<HomeStudentResponse>
}
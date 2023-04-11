package com.example.linkybproject.homes

import retrofit2.Call
import retrofit2.http.*


interface HomeStudentInterface {
    // 1.재학생 리스트 조회
    @GET("/home/all") // @Method(api address)
    fun homeStudent(
        @Header("Authorization") token: String
    ): Call<HomeStudentResponse>
}

interface HomeGraudateInterface {
    // 2. 졸업생 리스트 조회
    @GET("/home/all") // @Method(api address)
    fun homeGraduate(
        @Header("Authorization") token: String
    ): Call<HomeGraduateResponse>
}

interface HomeConnectTryInterface {
    // 3. 홈 연결시도 api
    @POST("/match/{userGetMatched}")
    fun homeConnectTry(
        @Header("Authorization") token: String
    ): Call<HomeConnectResponse>
}

interface HomeProfileInterface {
    // 4. 홈 화면 학생 프로필 조회 api
    @GET("users/{userId}")
    fun homeProfile(
        @Header("Authorization") token: String
    ): Call<HomeProfileResponse>
}
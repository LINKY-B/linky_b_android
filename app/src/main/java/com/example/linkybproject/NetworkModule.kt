package com.example.linkybproject

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection

const val BASE_URL = "http://192.168.0.3:8001"

fun getRetrofit(): Retrofit {
//    return Retrofit.Builder().baseUrl(BASE_URL)
//        .addConverterFactory(GsonConverterFactory.create()).build()

    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .hostnameVerifier(
            HostnameVerifier { hostname, session ->
                val hv = HttpsURLConnection.getDefaultHostnameVerifier()
                hv.verify("seolmunzip.shop", session)
            })
        .build()

    val gson: Gson = GsonBuilder().setLenient().create()

    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
//        .client(unsafeOkHttpClient().build())
        .client(client)
        .build()

    return retrofit
}
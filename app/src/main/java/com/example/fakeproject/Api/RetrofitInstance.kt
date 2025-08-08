package com.example.fakeproject.Api

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build()
    }

    val api: PostApi by lazy {
        retrofit.create(PostApi::class.java)
    }



}
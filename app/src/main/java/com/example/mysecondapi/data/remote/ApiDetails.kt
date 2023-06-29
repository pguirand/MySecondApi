package com.example.mysecondapi.data.remote

import okhttp3.OkHttp
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ApiDetails {

    const val BASE_URL = "https://api.jikan.moe/v4/"
    const val END_POINT = "random/anime"

    const val BEER_BASE_URL = "https://api.punkapi.com/v2/"
    const val BEER_END_POINT = "beers/random"

    const val DISNEY_BASE_URL = "https://api.disneyapi.dev/"
    const val DISNEY_END_POINT = "character"

    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
    val retrofitInstance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val retrofitBeer = Retrofit.Builder()
        .baseUrl(BEER_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    val retrofitDisney = Retrofit.Builder()
        .baseUrl(DISNEY_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()


    val apiClient = retrofitInstance.create(ApiCall::class.java)
    val beerClient = retrofitBeer.create(ApiCall::class.java)
    val disneyClient = retrofitDisney.create(ApiCall::class.java)



}
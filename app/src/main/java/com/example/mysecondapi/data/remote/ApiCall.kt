package com.example.mysecondapi.data.remote

import com.example.mysecondapi.data.model.anime.AnimeModel
import com.example.mysecondapi.data.model.beer.BeerModel
import com.example.mysecondapi.data.model.disney.DisneyModel
import retrofit2.http.GET

interface ApiCall {

    @GET(ApiDetails.END_POINT)
    suspend fun getRandomAnime(): AnimeModel

    @GET(ApiDetails.BEER_END_POINT)
    suspend fun getRandomBeer(): BeerModel

    @GET(ApiDetails.DISNEY_END_POINT)
    suspend fun getRandomDisney() : DisneyModel

}
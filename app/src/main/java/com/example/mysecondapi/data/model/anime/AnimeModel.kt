package com.example.mysecondapi.data.model.anime


import com.google.gson.annotations.SerializedName

data class AnimeModel(
    @SerializedName("data")
    val data: DataModel? = DataModel()
)
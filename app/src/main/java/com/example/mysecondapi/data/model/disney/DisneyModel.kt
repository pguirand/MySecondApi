package com.example.mysecondapi.data.model.disney


import com.google.gson.annotations.SerializedName

data class DisneyModel(
    @SerializedName("data")
    val data: List<DataModel?>? = listOf(),
    @SerializedName("info")
    val info: InfoModel? = InfoModel()
)
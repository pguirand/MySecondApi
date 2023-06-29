package com.example.mysecondapi.data.model.beer


import com.google.gson.annotations.SerializedName

data class FermentationModel(
    @SerializedName("temp")
    val temp: TempModel? = TempModel()
)
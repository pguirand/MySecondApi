package com.example.mysecondapi.data.model.anime


import com.google.gson.annotations.SerializedName

data class TitleModel(
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("type")
    val type: String? = ""
)
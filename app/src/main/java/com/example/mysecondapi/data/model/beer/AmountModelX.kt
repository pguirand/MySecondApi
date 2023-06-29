package com.example.mysecondapi.data.model.beer


import com.google.gson.annotations.SerializedName

data class AmountModelX(
    @SerializedName("unit")
    val unit: String? = "",
    @SerializedName("value")
    val value: Double? = 0.0
)
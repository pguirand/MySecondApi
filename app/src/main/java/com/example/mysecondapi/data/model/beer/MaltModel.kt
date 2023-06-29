package com.example.mysecondapi.data.model.beer


import com.google.gson.annotations.SerializedName

data class MaltModel(
    @SerializedName("amount")
    val amount: AmountModelX? = AmountModelX(),
    @SerializedName("name")
    val name: String? = ""
)
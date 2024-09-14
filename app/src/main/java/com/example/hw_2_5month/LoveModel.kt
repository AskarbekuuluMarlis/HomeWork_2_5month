package com.example.hw_2_5month
import com.google.gson.annotations.SerializedName

data class LoveModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    @SerializedName("percentage")
    val percentage: String,
    @SerializedName("result")
    val result: String
)
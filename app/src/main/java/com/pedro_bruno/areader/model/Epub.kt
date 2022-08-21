package com.pedro_bruno.areader.model


import com.google.gson.annotations.SerializedName

data class Epub(
    @SerializedName("isAvailable")
    val isAvailable: Boolean
)
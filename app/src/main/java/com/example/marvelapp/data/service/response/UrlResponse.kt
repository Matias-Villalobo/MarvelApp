package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class UrlResponse(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
)

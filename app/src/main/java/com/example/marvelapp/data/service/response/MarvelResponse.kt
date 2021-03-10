package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class MarvelResponse<T>(
        @SerializedName("results") val result: T
)

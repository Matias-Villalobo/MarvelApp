package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class SeriesResponse(
    @SerializedName("available") val available: Int,
    @SerializedName("collectionURI") val collectionURI: String,
    @SerializedName("returned") val returned: Int
)

package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class ThumbnailResponse(
    @SerializedName("path") var path: String,
    @SerializedName("extension") var extension: String
)

package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class MarvelResponse(
        @SerializedName("results") val result: List<CharacterResponse>
)

package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class CharacterResponse (
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String
)

package com.example.marvelapp.data.service.api


import com.example.marvelapp.data.service.response.MarvelBaseResponse
import retrofit2.Call
import retrofit2.http.GET

interface MarvelApi {
    @GET("characters")
    fun getCharacter(): Call<MarvelBaseResponse>
}

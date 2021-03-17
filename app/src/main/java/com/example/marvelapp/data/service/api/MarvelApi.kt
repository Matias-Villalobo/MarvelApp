package com.example.marvelapp.data.service.api

import com.example.marvelapp.data.service.response.CharacterEntity
import com.example.marvelapp.data.service.response.CharacterResponse
import com.example.marvelapp.data.service.response.MarvelBaseResponse
import com.example.marvelapp.data.service.response.MarvelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelApi {
    @GET("/v1/public/characters")
    fun getCharacter(): Call<MarvelBaseResponse<MarvelResponse<List<CharacterResponse>>>>

    @GET("/v1/public/characters/{characterId}")
    fun getSingleCharacter(@Path("characterId") id: Int): Call<MarvelBaseResponse<MarvelResponse<List<CharacterEntity>>>>
}

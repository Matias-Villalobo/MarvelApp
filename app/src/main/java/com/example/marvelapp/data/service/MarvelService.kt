package com.example.marvelapp.data.service

import com.example.marvelapp.data.service.entity.CharacterEntity
import io.reactivex.rxjava3.core.Observable

interface MarvelService {
    fun getCharacters(): Observable<List<CharacterEntity>>
}

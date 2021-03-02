package com.example.marvelapp.domain.contracts

import com.example.marvelapp.domain.entity.CharacterEntity
import io.reactivex.rxjava3.core.Observable

interface MarvelService {
    fun getCharacters(): Observable<List<CharacterEntity>>
}

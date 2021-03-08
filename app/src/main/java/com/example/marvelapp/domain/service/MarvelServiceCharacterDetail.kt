package com.example.marvelapp.domain.service

import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.entity.CharacterEntity
import io.reactivex.rxjava3.core.Observable

interface MarvelServiceCharacterDetail {
    fun getSingleCharacter(id :Int): Observable<CharacterDetailEntity>
}

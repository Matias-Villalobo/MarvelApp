package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.service.MarvelService
import io.reactivex.rxjava3.core.Observable

interface GetSingleCharacterUseCase {
    fun call(id: Int): Observable<CharacterDetailEntity>
}

class GetSingleCharacterUseCaseImpl constructor(private val marvelService: MarvelService) :
    GetSingleCharacterUseCase {
    override fun call(id: Int): Observable<CharacterDetailEntity> = marvelService.getSingleCharacter(id)
}

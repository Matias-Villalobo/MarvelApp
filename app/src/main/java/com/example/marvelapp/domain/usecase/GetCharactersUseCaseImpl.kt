package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.service.MarvelService
import com.example.marvelapp.domain.entity.CharacterEntity
import io.reactivex.rxjava3.core.Observable

interface GetCharacterUseCase {
    fun call(): Observable<List<CharacterEntity>>
}

class GetCharactersUseCaseImpl constructor(private val marvelService: MarvelService) :
    GetCharacterUseCase {
    override fun call(): Observable<List<CharacterEntity>> = marvelService.getCharacters()
}

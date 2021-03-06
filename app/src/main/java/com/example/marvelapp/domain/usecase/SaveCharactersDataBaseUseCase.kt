package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.local.LocalMarvelDataBase

interface SaveCharactersDataBaseUseCase {
    fun call(characters: List<CharacterEntity>)
}

class SaveCharactersDataBaseUseCaseImpl(private val localMarvelDataBase: LocalMarvelDataBase) :
    SaveCharactersDataBaseUseCase {

    override fun call(characters: List<CharacterEntity>) {
        localMarvelDataBase.saveCharacters(characters)
    }
}

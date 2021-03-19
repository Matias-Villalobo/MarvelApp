package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.local.LocalMarvelDataBase

interface LoadCharactersUseCase {
    fun getChractersFromLocal(): List<CharacterEntity>
}

class LoadCharactersUseCaseImpl(private val localMarvelDataBase: LocalMarvelDataBase) : LoadCharactersUseCase {
    override fun getChractersFromLocal(): List<CharacterEntity> = localMarvelDataBase.loadCharacters()
}

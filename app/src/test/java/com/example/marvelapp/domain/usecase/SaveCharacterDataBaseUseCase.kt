package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.local.LocalMarvelDataBase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class SaveCharacterDataBaseUseCase {
    private var localMarvelDataBase: LocalMarvelDataBase = mock()
    private var characters: List<CharacterEntity> = mock()
    private lateinit var saveCharacterServiceUseCase : SaveCharactersDataBaseUseCaseImpl

    @Before
    fun setUp() {
        saveCharacterServiceUseCase = SaveCharactersDataBaseUseCaseImpl(localMarvelDataBase)
    }

    @Test
    fun `verify save character is call`() {
        saveCharacterServiceUseCase.call(characters)
        verify(localMarvelDataBase).saveCharacters(characters)
    }
}

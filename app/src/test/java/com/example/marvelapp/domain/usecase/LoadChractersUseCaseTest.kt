package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.local.LocalMarvelDataBase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Before
import org.junit.Test

class LoadChractersUseCaseTest {
    private var localMarvelDataBase: LocalMarvelDataBase = mock()
    private var characters: List<CharacterEntity> = mock()

    @Before
    fun setUp() {
        whenever(localMarvelDataBase.loadCharacters()).thenReturn(characters)
    }

    @Test
    fun call() {
        val loadCharacterServiceUseCase = LoadCharactersUseCaseImpl(localMarvelDataBase)
        loadCharacterServiceUseCase.call()
        verify(localMarvelDataBase).loadCharacters()
    }
}

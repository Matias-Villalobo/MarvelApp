package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.service.MarvelService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class GetCharactersUseCaseTest {
    private var marvelService: MarvelService = mock()
    private var characters: List<CharacterEntity> = mock()
    private lateinit var getCharacterServiceUseCase : GetCharactersUseCaseImpl

    @Before
    fun setUp() {
        getCharacterServiceUseCase = GetCharactersUseCaseImpl(marvelService)
    }

    @Test
    fun call() {
        getCharacterServiceUseCase.call()
        whenever(marvelService.getCharacters()).thenReturn(Observable.just(characters))
        verify(marvelService).getCharacters()
    }
}

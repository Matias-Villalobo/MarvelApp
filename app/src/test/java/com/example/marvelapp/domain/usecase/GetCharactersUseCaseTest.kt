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

    @Before
    fun setUp() {
        whenever(marvelService.getCharacters()).thenReturn(Observable.just(characters))
    }

    @Test
    fun call() {
        val getCharacterServiceUseCase = GetCharactersUseCaseImpl(marvelService)
        getCharacterServiceUseCase.call()
        verify(marvelService).getCharacters()
    }
}

package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.service.MarvelService
import com.example.marvelapp.utils.CharactersConstantsUtils.ID
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class GetSingleCharacterUseCaseTest {
    private var marvelService: MarvelService = mock()
    private var characters: CharacterDetailEntity = mock()
    private lateinit var getCharacterServiceUseCase : GetSingleCharacterUseCaseImpl

    @Before
    fun setUp() {
      getCharacterServiceUseCase= GetSingleCharacterUseCaseImpl(marvelService)
    }

    @Test
    fun call() {
        getCharacterServiceUseCase.call(ID)
        whenever(marvelService.getSingleCharacter(ID)).thenReturn(Observable.just(characters))
        verify(marvelService).getSingleCharacter(ID)
    }
}

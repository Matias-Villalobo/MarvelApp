package com.example.marvelapp.domain.usecase

import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.service.MarvelService
import com.example.marvelapp.presentation.mvp.utils.ConstantsUtils.characterID
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Test

class GetSingleCharacterUseCaseTest {
    private var marvelService: MarvelService = mock()
    private var characters: CharacterDetailEntity = mock()

    @Before
    fun setUp() {
        whenever(marvelService.getSingleCharacter(characterID)).thenReturn(Observable.just(characters))
    }

    @Test
    fun call() {
        val getCharacterServiceUseCase = GetSingleCharacterUseCaseImpl(marvelService)
        getCharacterServiceUseCase.call(characterID)
        verify(marvelService).getSingleCharacter(characterID)
    }
}

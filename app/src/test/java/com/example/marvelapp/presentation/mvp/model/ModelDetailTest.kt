package com.example.marvelapp.presentation.mvp.model

import com.example.marvelapp.domain.usecase.GetSingleCharacterUseCase
import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract
import com.example.marvelapp.utils.CharactersConstantsUtils.ID
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class ModelDetailTest {
    private lateinit var model: MarvelAppDetailContract.Model
    private val getSingleCharacterUseCase: GetSingleCharacterUseCase = mock()

    @Before
    fun setup() {
        model = MarvelDetailModel(getSingleCharacterUseCase)
    }

    @Test
    fun `get single character data`() {
        model.getDataSingleCharacter(ID)
        verify(getSingleCharacterUseCase).call(ID)
    }
}

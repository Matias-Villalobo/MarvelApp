package com.example.marvelapp.presentation.mvp.model

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import com.example.marvelapp.domain.usecase.LoadCharactersUseCase
import com.example.marvelapp.domain.usecase.SaveCharactersDataBaseUseCase
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test

class ModelTest {
    private lateinit var model: MarvelAppContract.MarvelAppModel
    private val getCharacterUseCase: GetCharacterUseCase = mock()
    private val saveCharacterDataBaseUseCase: SaveCharactersDataBaseUseCase = mock()
    private val loadCharacterDatabaseUseCase: LoadCharactersUseCase = mock()
    private var characters: List<CharacterEntity> = mock()

    @Before
    fun setup() {
        model = MarvelAppModel(getCharacterUseCase,saveCharacterDataBaseUseCase,loadCharacterDatabaseUseCase)
    }

    @Test
    fun `get the heroes data`() {
        model.getHeroesData()
        verify(getCharacterUseCase).call()
    }

    @Test
    fun `load the heroes from local data base`() {
        model.loadCharactersFromDataBase()
        verify(loadCharacterDatabaseUseCase).call()
    }

    @Test
    fun `save the heroes in the local data base`() {
        model.addCharactersToDataBase(characters)
        verify(saveCharacterDataBaseUseCase).call(characters)
    }
}

package com.example.marvelapp.presentation.mvp.model

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import com.example.marvelapp.domain.usecase.LoadCharactersUseCase
import com.example.marvelapp.domain.usecase.SaveCharactersDataBaseUseCase
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import io.reactivex.rxjava3.core.Observable

class MarvelAppModel(
    private val getCharacterUseCases: GetCharacterUseCase,
    private val saveCharactersDataBaseUseCase: SaveCharactersDataBaseUseCase,
    private val loadCharactersUseCase: LoadCharactersUseCase
) : MarvelAppContract.MarvelAppModel {

    override fun getHeroesData(): Observable<List<CharacterEntity>> =
        getCharacterUseCases.call()

    override fun addCharactersToDataBase(data: List<CharacterEntity>) {
        saveCharactersDataBaseUseCase.call(data)
    }

    override fun loadCharactersFromDataBase(): List<CharacterEntity> =
        loadCharactersUseCase.call()
}

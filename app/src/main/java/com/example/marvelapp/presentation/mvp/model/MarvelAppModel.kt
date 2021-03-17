package com.example.marvelapp.presentation.mvp.model

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import com.example.marvelapp.domain.usecase.SaveCharactersDataBaseUseCase
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import io.reactivex.rxjava3.core.Observable

class MarvelAppModel(
    private val getCharacterUseCases: GetCharacterUseCase,
    private val saveCharactersDataBaseUseCase: SaveCharactersDataBaseUseCase
) : MarvelAppContract.MarvelAppModel {

    override fun getHeroesData(): Observable<List<CharacterEntity>> =
        getCharacterUseCases.call()

    override fun addHeroesToDataBase(data: List<CharacterEntity>) {
        saveCharactersDataBaseUseCase.call(data)
    }


}

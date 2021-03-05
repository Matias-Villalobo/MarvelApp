package com.example.marvelapp.presentation.mvp.model

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.usecase.GetCharacterUseCase
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import io.reactivex.rxjava3.core.Observable

class MarvelAppModel(private val getCharacterUseCases: GetCharacterUseCase) :
    MarvelAppContract.MarvelAppModel {
    override var charactersList: List<CharacterEntity>
        get() = TODO("Not yet implemented")
        set(value) {}

    override fun getHeroesData(): Observable<List<CharacterEntity>> =
        getCharacterUseCases.call()

}

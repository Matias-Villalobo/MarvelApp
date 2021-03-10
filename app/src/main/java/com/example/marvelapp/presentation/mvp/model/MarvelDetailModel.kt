package com.example.marvelapp.presentation.mvp.model

import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.usecase.GetSingleCharacterUseCase
import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract
import io.reactivex.rxjava3.core.Observable

class MarvelDetailModel(private val getSingleCharacterUseCase: GetSingleCharacterUseCase) :
    MarvelAppDetailContract.Model {

    override fun getDataSingleCharacter(id: Int): Observable<CharacterDetailEntity> =
        getSingleCharacterUseCase.call(id)
}

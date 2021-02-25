package com.example.marvelapp.mvp.model

import com.example.marvelapp.data.service.MarvelService
import com.example.marvelapp.data.service.entity.CharacterEntity
import com.example.marvelapp.mvp.contract.MarvelAppContract
import io.reactivex.rxjava3.core.Observable

class MarvelAppModel (private val marvelService: MarvelService) : MarvelAppContract.MarvelAppModel {

    override fun getHeroesData(): Observable<List<CharacterEntity>> =
        marvelService.getCharacters()
    }


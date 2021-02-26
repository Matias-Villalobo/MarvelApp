package com.example.marvelapp.mvp.contract

import com.example.marvelapp.data.service.entity.CharacterEntity
import io.reactivex.rxjava3.core.Observable

interface MarvelAppContract {

    interface MarvelAppModel {
        fun getHeroesData(): Observable<List<CharacterEntity>>
    }

    interface MarvelAppPresenter {
        fun getHeroes()
    }

    interface MarvelAppView {
        fun showData(data:List<CharacterEntity>)
        fun showError()
    }
}

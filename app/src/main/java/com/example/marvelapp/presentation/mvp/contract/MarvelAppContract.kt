package com.example.marvelapp.presentation.mvp.contract

import com.example.marvelapp.domain.entity.CharacterEntity
import io.reactivex.rxjava3.core.Observable

interface MarvelAppContract {

    interface MarvelAppModel {
        fun getHeroesData(): Observable<List<CharacterEntity>>
        fun addHeroesToDataBase(data: List<CharacterEntity>)

    }

    interface MarvelAppView {
        fun showData(data: List<CharacterEntity>)
        fun showError()
        fun showLoading()
        fun hideLoading()
        fun showCharacterInfo(characterId: Int)
    }

    interface MarvelAppPresenter {
        fun fetchHeroes()
        fun onCharacterClicked(characterId: Int)
    }
}

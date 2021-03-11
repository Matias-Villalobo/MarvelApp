package com.example.marvelapp.presentation.mvp.contract

import com.example.marvelapp.domain.entity.CharacterDetailEntity
import io.reactivex.rxjava3.core.Observable

interface MarvelAppDetailContract {
    interface Model {
        fun getDataSingleCharacter(id: Int): Observable<CharacterDetailEntity>
    }

    interface View {
        fun showFragmentData(data: CharacterDetailEntity)
        fun showFragmentError()
    }

    interface Presenter {
        fun retrieveSingleCharacterInfo(characterId: Int)
    }
}

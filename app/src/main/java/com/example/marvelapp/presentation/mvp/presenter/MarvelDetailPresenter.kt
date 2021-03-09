package com.example.marvelapp.presentation.mvp.presenter

import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MarvelDetailPresenter(
    private val model: MarvelAppDetailContract.Model,
    private val view: MarvelAppDetailContract.View
) : MarvelAppDetailContract.Presenter {

    override fun retrieveSingleCharacterInfo(characterId: Int) {
        model.getDataSingleCharacter(characterId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    val pepe = 1 //this variable only exists for the purpose of being able to test the service call. Once the view is implemented, it will be deleted
                },
                {
                })
    }
}

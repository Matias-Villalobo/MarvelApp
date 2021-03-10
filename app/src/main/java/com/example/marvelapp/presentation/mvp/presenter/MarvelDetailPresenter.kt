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
                    //At the moment the view has not yet been implemented, in the future here will be the respective methods of displaying the data
                },
                { //At the moment the view has not yet been implemented, in the future here will be the respective methods of displaying the errors
                })
    }
}

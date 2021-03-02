package com.example.marvelapp.presentation.mvp.presenter

import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MarvelAppPresenter(
        private val model: MarvelAppContract.MarvelAppModel,
        private val view: MarvelAppContract.MarvelAppView
) : MarvelAppContract.MarvelAppPresenter {

    override fun getHeroes() {
        model.getHeroesData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data -> view.showData(data) }, { view.showError() })
    }

}
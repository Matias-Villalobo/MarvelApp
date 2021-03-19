package com.example.marvelapp.presentation.mvp.presenter

import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MarvelAppPresenter(
    private val model: MarvelAppContract.MarvelAppModel,
    private val view: MarvelAppContract.MarvelAppView
) : MarvelAppContract.MarvelAppPresenter {

    override fun fetchHeroes() {
        view.showLoading()
        model.getHeroesData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { data ->
                    model.addCharactersToDataBase(data)
                    view.showData(data)
                    view.hideLoading()
                },
                {
                    view.showError()
                    view.hideLoading()
                })
    }

    override fun onCharacterClicked(characterId: Int) {
        view.showCharacterInfo(characterId)
    }

    override fun getCharactersFromDataBase() {
        view.cleanRecycler()
        view.showLoading()
        model.loadCharactersFromDataBase().apply {
            view.showData(this)
            view.hideLoading()
        }
    }

}

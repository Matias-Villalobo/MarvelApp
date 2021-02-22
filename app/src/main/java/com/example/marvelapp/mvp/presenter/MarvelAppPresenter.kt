package com.example.marvelapp.mvp.presenter

import com.example.marvelapp.mvp.contract.MarvelAppContract

class MarvelAppPresenter(
        private val model: MarvelAppContract.MarvelAppModel,
        private val view: MarvelAppContract.MarvelAppView
) : MarvelAppContract.MarvelAppPresenter {
}

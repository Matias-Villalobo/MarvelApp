package com.example.marvelapp.presentation.mvp.presenter

import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract

class DetailPresenter (
    private val model: MarvelAppDetailContract.Model,
    private val view: MarvelAppDetailContract.View
) : MarvelAppDetailContract.Presenter {

    override fun retrieveSingleCharacterInfo() {
        TODO("Not yet implemented")
    }
}

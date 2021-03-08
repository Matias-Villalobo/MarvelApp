package com.example.marvelapp.presentation.mvp.contract

interface MarvelAppDetailContract {
    interface Model {
        fun getDataSingleCharacter()
    }

    interface View {
        fun showFragmentData()
        fun showFragmentError()
    }

    interface Presenter {
        fun retrieveSingleCharacterInfo()
    }
}

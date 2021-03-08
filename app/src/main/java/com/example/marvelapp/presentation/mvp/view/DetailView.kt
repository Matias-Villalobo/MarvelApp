package com.example.marvelapp.presentation.mvp.view

import androidx.fragment.app.DialogFragment
import com.example.marvelapp.databinding.CharacterDetailLayoutBinding
import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract

class DetailView (
    fragment: DialogFragment,
    private val binding: CharacterDetailLayoutBinding
) : MarvelAppDetailContract.View,
    FragmentView(fragment) {

    override fun showFragmentData() {
        TODO("Not yet implemented")
    }

    override fun showFragmentError() {
        TODO("Not yet implemented")
    }
}

package com.example.marvelapp.presentation.mvp.view

import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.marvelapp.R
import com.example.marvelapp.databinding.CharacterDetailLayoutBinding
import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract

class MarvelDetailView(
    fragment: DialogFragment,
    private val binding: CharacterDetailLayoutBinding
) : MarvelAppDetailContract.View,
    FragmentView(fragment) {

    override fun showFragmentData(data: CharacterDetailEntity) {
        binding.characterName.text = data.name
        binding.characterDescription.text = data.description
        binding.characterDetailsLink.text = data.resourceUri
        binding.characterAppearancesComics.text = data.comics.available.toString()
        binding.characterComicsLink.text = data.comics.collectionURI
    }

    override fun showFragmentError() {
        Toast.makeText(context, R.string.connection_not_established, Toast.LENGTH_SHORT).show()
    }
}

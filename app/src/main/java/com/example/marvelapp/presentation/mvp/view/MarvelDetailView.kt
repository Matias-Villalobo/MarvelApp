package com.example.marvelapp.presentation.mvp.view

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.databinding.CharacterDetailLayoutBinding
import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.presentation.fragment.MarvelDetailsFragment
import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract
import java.lang.System.load

class MarvelDetailView(
    fragment: DialogFragment,
    private val binding: CharacterDetailLayoutBinding
) : MarvelAppDetailContract.View,
    FragmentView(fragment) {

    override fun showFragmentData(data: CharacterDetailEntity) {
        this.context?.let {
            Glide.with(it)
                .load("${data.thumbnail.path}.${data.thumbnail.extension}")
                .into(binding.characterImage)
        }
        binding.characterName.text = data.name
        binding.characterDescription.text = data.description
        binding.characterDetailsLink.text = data.resourceUri
        binding.characterAppearancesComics.text = data.comics.available.toString()
        binding.characterComicsLink.text = data.comics.collectionURI

    }

    override fun showFragmentError() {
        Toast.makeText(context, R.string.connection_not_established, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        binding.loadingBar.isInvisible = false
        binding.characterDescriptionTitle.isInvisible = true
        binding.moreDetailsTitle.isInvisible = true
        binding.characterAppearancesTitle.isInvisible = true
        binding.characterComics.isInvisible = true
        binding.characterImage.isInvisible = true
    }

    override fun hideLoading() {
        binding.loadingBar.isInvisible = true
        binding.characterDescriptionTitle.isInvisible = false
        binding.moreDetailsTitle.isInvisible = false
        binding.characterAppearancesTitle.isInvisible = false
        binding.characterComics.isInvisible = false
        binding.characterImage.isInvisible = false
    }
}

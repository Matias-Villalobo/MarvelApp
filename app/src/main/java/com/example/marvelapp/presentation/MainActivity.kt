package com.example.marvelapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelapp.data.service.implementation.MarvelServiceImpl
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.domain.usecase.GetCharactersUseCaseImpl
import com.example.marvelapp.presentation.adapter.ItemClicked
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import com.example.marvelapp.presentation.mvp.model.MarvelAppModel
import com.example.marvelapp.presentation.mvp.presenter.MarvelAppPresenter
import com.example.marvelapp.presentation.mvp.view.MarvelAppView

class MainActivity : AppCompatActivity(), ItemClicked {

    private lateinit var presenter: MarvelAppContract.MarvelAppPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MarvelAppPresenter(
            MarvelAppModel(GetCharactersUseCaseImpl(MarvelServiceImpl())),
            MarvelAppView(this, binding)
        )
        presenter.fetchHeroes()
    }

    override fun characterClicked(characterId: Int) {
        presenter.onCharacterClicked(characterId)
    }
}

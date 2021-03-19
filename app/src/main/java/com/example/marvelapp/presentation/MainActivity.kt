package com.example.marvelapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelapp.data.local.LocalMarvelDatabaseImpl
import com.example.marvelapp.data.mapper.CharacterRealmMapper
import com.example.marvelapp.data.service.implementation.MarvelServiceImpl
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.domain.usecase.GetCharactersUseCaseImpl
import com.example.marvelapp.domain.usecase.LoadCharactersUseCaseImpl
import com.example.marvelapp.domain.usecase.SaveCharactersDataBaseUseCaseImpl
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
        floatingButton()

        presenter = MarvelAppPresenter(
            MarvelAppModel(
                GetCharactersUseCaseImpl(MarvelServiceImpl()),
                SaveCharactersDataBaseUseCaseImpl(LocalMarvelDatabaseImpl(CharacterRealmMapper)),
                LoadCharactersUseCaseImpl(LocalMarvelDatabaseImpl(CharacterRealmMapper))
            ),
            MarvelAppView(this, binding)
        )
        presenter.fetchHeroes()
    }

    private fun floatingButton() {
        val button = binding.fab
        button.setOnClickListener { presenter.getCharactersFromDataBase() }
    }

    override fun characterClicked(characterId: Int) {
        presenter.onCharacterClicked(characterId)
    }
}

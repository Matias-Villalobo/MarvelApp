package com.example.marvelapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelapp.data.serviceImpl.MarvelServiceImpl
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.domain.usecases.GetCharacterUseCase
import com.example.marvelapp.domain.usecases.GetCharactersUseCaseImpl
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import com.example.marvelapp.presentation.mvp.model.MarvelAppModel
import com.example.marvelapp.presentation.mvp.presenter.MarvelAppPresenter
import com.example.marvelapp.presentation.mvp.view.MarvelAppView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MarvelAppContract.MarvelAppPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        val getCharacterUseCase = GetCharactersUseCaseImpl(MarvelServiceImpl())
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MarvelAppPresenter(MarvelAppModel(getCharacterUseCase), MarvelAppView(this, binding))
        presenter.getHeroes()
    }
}

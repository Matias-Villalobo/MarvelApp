package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelapp.data.service.MarvelServiceImpl
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.mvp.contract.MarvelAppContract
import com.example.marvelapp.mvp.model.MarvelAppModel
import com.example.marvelapp.mvp.presenter.MarvelAppPresenter
import com.example.marvelapp.mvp.view.MarvelAppView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: MarvelAppContract.MarvelAppPresenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter = MarvelAppPresenter(MarvelAppModel(MarvelServiceImpl()), MarvelAppView(this, binding))
        presenter.getHeroes()
    }
}

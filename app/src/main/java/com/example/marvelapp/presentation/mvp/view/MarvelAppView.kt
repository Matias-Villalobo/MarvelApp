package com.example.marvelapp.presentation.mvp.view

import android.app.Activity
import android.widget.Toast
import com.example.marvelapp.R
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.domain.entity.CharacterEntity

class MarvelAppView(activity: Activity, private val binding: ActivityMainBinding) :
        ActivityView(activity), MarvelAppContract.MarvelAppView {
    override fun showData(data: List<CharacterEntity>) {
        Toast.makeText(context, R.string.conection_established, Toast.LENGTH_SHORT).show()
    }

    override fun showError() {
        Toast.makeText(context, R.string.conection_not_established, Toast.LENGTH_SHORT).show()
    }
}

package com.example.marvelapp.presentation.mvp.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapp.R
import com.example.marvelapp.presentation.fragment.MarvelDetailsFragment
import com.example.marvelapp.presentation.mvp.contract.MarvelAppContract
import com.example.marvelapp.databinding.ActivityMainBinding
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.presentation.adapter.CharacterAdapter
import com.example.marvelapp.presentation.adapter.ItemClicked
import com.example.marvelapp.presentation.fragment.MarvelDetailsFragment.Companion.TAG

class MarvelAppView(activity: Activity, private val binding: ActivityMainBinding) :
    ActivityView(activity), MarvelAppContract.MarvelAppView {

    override fun showData(characterFiltered: List<CharacterEntity>) {
        binding.recycleView.layoutManager = LinearLayoutManager(context)
        binding.recycleView.adapter = CharacterAdapter(characterFiltered, (activity as ItemClicked))
    }

    override fun showError() {
        Toast.makeText(context, R.string.connection_not_established, Toast.LENGTH_SHORT).show()
    }

    override fun showLoading() {
        binding.loadingBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.loadingBar.visibility = View.GONE
    }

    override fun showCharacterInfo(characterId: Int) {
        MarvelDetailsFragment.newInstance(characterId)
            .show((context as FragmentActivity).supportFragmentManager, TAG)
    }
}

package com.example.marvelapp.presentation.mvp.view

import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelapp.R
import com.example.marvelapp.databinding.CharacterDetailLayoutBinding
import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract

class MarvelDetailView(
    fragment: DialogFragment,
    private val binding: CharacterDetailLayoutBinding
) : MarvelAppDetailContract.View,
    FragmentView(fragment) {

    override fun showFragmentData() {
        /*Not yet implemented, it will be in the next PR*/
    }

    override fun showFragmentError() {
        Toast.makeText(context, R.string.conection_not_established, Toast.LENGTH_SHORT).show()
    }
}

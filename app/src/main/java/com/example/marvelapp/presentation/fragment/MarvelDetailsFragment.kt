package com.example.marvelapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.marvelapp.databinding.CharacterDetailLayoutBinding

class MarvelDetailsFragment : DialogFragment() {
    private lateinit var binding: CharacterDetailLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharacterDetailLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//ESTO ES UNA PRUEBA


    }

    companion object {
        const val TAG: String = "MARVELITEMFRAGMENT"
        const val NAME_TAG = "NAME"
        const val DESCRIPTION_TAG = "DESCRIPTION"
        const val IMAGE_TAG = "IMAGE"
        const val TOTAL_COMICS_TAG = "TOTAL_COMICS"
        const val COMICS_LINK_TAG = "COMICS_LINK"
        const val URLS_TAG = "URLS_LINK"


        fun newInstance(
        ): MarvelDetailsFragment {
            val fragment = MarvelDetailsFragment()
            return fragment
        }
    }

}

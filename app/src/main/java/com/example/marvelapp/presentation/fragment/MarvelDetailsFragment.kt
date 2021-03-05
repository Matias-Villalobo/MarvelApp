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

    }

    companion object {

        const val TAG: String = "marvelItemFragment"
        fun newInstance(

        ): MarvelDetailsFragment {
            val args = Bundle()
            val fragment = MarvelDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

}

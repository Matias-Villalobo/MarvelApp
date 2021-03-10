package com.example.marvelapp.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.marvelapp.data.service.implementation.MarvelServiceImpl
import com.example.marvelapp.databinding.CharacterDetailLayoutBinding
import com.example.marvelapp.domain.usecase.GetSingleCharacterUseCaseImpl
import com.example.marvelapp.presentation.mvp.contract.MarvelAppDetailContract
import com.example.marvelapp.presentation.mvp.model.MarvelDetailModel
import com.example.marvelapp.presentation.mvp.presenter.MarvelDetailPresenter
import com.example.marvelapp.presentation.mvp.view.MarvelDetailView

class MarvelDetailsFragment : DialogFragment() {
    private lateinit var presenter: MarvelAppDetailContract.Presenter
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
        presenter = MarvelDetailPresenter(
            MarvelDetailModel(
                GetSingleCharacterUseCaseImpl(MarvelServiceImpl())
            ), MarvelDetailView(this, binding)
        )
        presenter.retrieveSingleCharacterInfo(
            arguments?.getInt(CHARACTER_ID) ?: ZERO_INT
        )
    }

    companion object {
        const val TAG: String = "MARVEL_ITEM_FRAGMENT"
        const val CHARACTER_ID: String = "CHARACTER_ID"
        const val ZERO_INT = 0

        fun newInstance(characterId: Int): MarvelDetailsFragment {
            val args = Bundle()
            args.putInt(CHARACTER_ID, characterId)

            val fragment = MarvelDetailsFragment()
            fragment.arguments = args
            return fragment
        }
    }

}

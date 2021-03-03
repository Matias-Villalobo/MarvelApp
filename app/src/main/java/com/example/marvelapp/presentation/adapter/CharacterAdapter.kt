package com.example.marvelapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelapp.R
import com.example.marvelapp.databinding.CharacterCardLayoutBinding
import com.example.marvelapp.domain.entity.CharacterEntity


class CharacterAdapter(private val character: List<CharacterEntity>) :
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.character_card_layout, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(character[position])
    }

    override fun getItemCount() = character.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CharacterCardLayoutBinding.bind(itemView)

        fun bind(characterItem: CharacterEntity) {
            binding.apply {
                tvItem.text = characterItem.name
                Glide.with(itemView.context)
                    .load("${characterItem.thumbnail.path}.${characterItem.thumbnail.extension}")
                    .into(imageThumbnail)
            }
        }
    }

}

package com.example.marvelapp.domain.local

import com.example.marvelapp.domain.entity.CharacterEntity

interface LocalMarvelDataBase {
    fun saveCharacters(data: List<CharacterEntity>)
    fun loadCharacters(): List<CharacterEntity>
}

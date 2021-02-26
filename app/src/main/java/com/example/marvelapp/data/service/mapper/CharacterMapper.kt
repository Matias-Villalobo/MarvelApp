package com.example.marvelapp.data.service.mapper

import com.example.marvelapp.data.service.response.CharacterResponse
import com.example.marvelapp.data.service.entity.CharacterEntity

object CharacterMapper {

    private fun transformCharacter(characterResponse: CharacterResponse): CharacterEntity = CharacterEntity(
            characterResponse.id,
            characterResponse.name,
            characterResponse.description,
    )

    fun transformListOfCharacters(charactersResponse: List<CharacterResponse>): List<CharacterEntity> = charactersResponse.map { transformCharacter(it) }

}

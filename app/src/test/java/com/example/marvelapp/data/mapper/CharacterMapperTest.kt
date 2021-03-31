package com.example.marvelapp.data.mapper

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.utils.CharactersConstantsUtils.CHARACTER_DETAIL_ENTITY
import com.example.marvelapp.utils.CharactersConstantsUtils.CHARACTER_ENTITY
import com.example.marvelapp.utils.CharactersConstantsUtils.CHARACTER_RESPONSE
import com.example.marvelapp.utils.CharactersConstantsUtils.ONE_VALUE
import com.example.marvelapp.utils.CharactersConstantsUtils.ZERO_VALUE
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterMapperTest {

    @Test
    fun validValueForCharacterssest() {
        val actual = CharacterMapper.transformCharacter(CHARACTER_RESPONSE)
        assertEquals(actual, CHARACTER_ENTITY)
    }

    @Test
    fun transformSingleCharacter() {
        val singleCharacter = CharacterMapper.transformSingleCharacter(CHARACTER_RESPONSE)
        assertEquals(singleCharacter, CHARACTER_DETAIL_ENTITY)
    }

    @Test
    fun transformListoOfCharactersEmptyTest() {
        assertEquals(ZERO_VALUE, CharacterMapper.transformListOfCharacters(emptyList()).size)
    }

    @Test
    fun transformListoOfCharactersTest() {
        val charactersList = CharacterMapper.transformListOfCharacters(listOf(CHARACTER_RESPONSE))
        assertForValidValuesForListOfCharacter(charactersList)
    }

    private fun assertForValidValuesForListOfCharacter(charactersList: List<CharacterEntity>) {
        assertEquals(ONE_VALUE, charactersList.size)
        for (character in charactersList) {
            assertEquals(character, CHARACTER_ENTITY)
        }
    }

}

package com.example.marvelapp.data.mapper

import com.example.marvelapp.utils.CharactersConstantsUtils.AVAILABLE
import com.example.marvelapp.utils.CharactersConstantsUtils.CHARACTER_RESPONSE
import com.example.marvelapp.utils.CharactersConstantsUtils.COLLECTIONURI
import com.example.marvelapp.utils.CharactersConstantsUtils.DESCRIPTION
import com.example.marvelapp.utils.CharactersConstantsUtils.EXTENSION
import com.example.marvelapp.utils.CharactersConstantsUtils.ID
import com.example.marvelapp.utils.CharactersConstantsUtils.MODIFIED
import com.example.marvelapp.utils.CharactersConstantsUtils.NAME
import com.example.marvelapp.utils.CharactersConstantsUtils.ONE_VALUE
import com.example.marvelapp.utils.CharactersConstantsUtils.PATH
import com.example.marvelapp.utils.CharactersConstantsUtils.RESOURCEURI
import com.example.marvelapp.utils.CharactersConstantsUtils.RETURNED
import com.example.marvelapp.utils.CharactersConstantsUtils.URL_LIST_RESPONSE
import com.example.marvelapp.utils.CharactersConstantsUtils.ZERO_VALUE
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterMapperTest {

    @Test
    fun validValuestest() {
        val actual = CharacterMapper.transformCharacter(CHARACTER_RESPONSE)
        assertEquals(ID, actual.id)
        assertEquals(NAME, actual.name)
        assertEquals(DESCRIPTION, actual.description)
        assertEquals(MODIFIED, actual.modified)
        assertEquals(PATH, actual.thumbnail.path)
        assertEquals(EXTENSION, actual.thumbnail.extension)
        assertEquals(RESOURCEURI, actual.resourceUri)
        assertEquals(AVAILABLE, actual.events.available)
        assertEquals(COLLECTIONURI, actual.events.collectionURI)
        assertEquals(RETURNED, actual.events.returned)
        assertEquals(AVAILABLE, actual.stories.available)
        assertEquals(COLLECTIONURI, actual.stories.collectionURI)
        assertEquals(RETURNED, actual.stories.returned)
        assertEquals(AVAILABLE, actual.series.available)
        assertEquals(COLLECTIONURI, actual.series.collectionURI)
        assertEquals(RETURNED, actual.series.returned)
        assertEquals(AVAILABLE, actual.comics.available)
        assertEquals(COLLECTIONURI, actual.comics.collectionURI)
        assertEquals(RETURNED, actual.comics.returned)
        assertEquals(RETURNED, actual.comics.returned)
        assertEquals(URL_LIST_RESPONSE[ZERO_VALUE].type, actual.urls[ZERO_VALUE].type)
        assertEquals(URL_LIST_RESPONSE[ZERO_VALUE].url, actual.urls[ZERO_VALUE].url)
    }

    @Test
    fun transformSingleCharacter() {
        val actual = CharacterMapper.transformSingleCharacter(CHARACTER_RESPONSE)
        assertEquals(ID, actual.id)
        assertEquals(NAME, actual.name)
        assertEquals(DESCRIPTION, actual.description)
        assertEquals(MODIFIED, actual.modified)
        assertEquals(PATH, actual.thumbnail.path)
        assertEquals(EXTENSION, actual.thumbnail.extension)
        assertEquals(RESOURCEURI, actual.resourceUri)
        assertEquals(AVAILABLE, actual.events.available)
        assertEquals(COLLECTIONURI, actual.events.collectionURI)
        assertEquals(RETURNED, actual.events.returned)
        assertEquals(AVAILABLE, actual.stories.available)
        assertEquals(COLLECTIONURI, actual.stories.collectionURI)
        assertEquals(RETURNED, actual.stories.returned)
        assertEquals(AVAILABLE, actual.series.available)
        assertEquals(COLLECTIONURI, actual.series.collectionURI)
        assertEquals(RETURNED, actual.series.returned)
        assertEquals(AVAILABLE, actual.comics.available)
        assertEquals(COLLECTIONURI, actual.comics.collectionURI)
        assertEquals(RETURNED, actual.comics.returned)
        assertEquals(RETURNED, actual.comics.returned)
        assertEquals(URL_LIST_RESPONSE[ZERO_VALUE].type, actual.urls[ZERO_VALUE].type)
        assertEquals(URL_LIST_RESPONSE[ZERO_VALUE].url, actual.urls[ZERO_VALUE].url)
    }

    @Test
    fun transformListoOfCharactersEmptyTest() {
        assertEquals(ZERO_VALUE, CharacterMapper.transformListOfCharacters(emptyList()).size)
    }

    @Test
    fun transformListoOfCharactersTest() {
        val charactersList = CharacterMapper.transformListOfCharacters(listOf(CHARACTER_RESPONSE))
        assertEquals(ONE_VALUE, charactersList.size)
        assertEquals(ID, charactersList[ZERO_VALUE].id)
        assertEquals(NAME, charactersList[ZERO_VALUE].name)
        assertEquals(DESCRIPTION, charactersList[ZERO_VALUE].description)
        assertEquals(PATH, charactersList[ZERO_VALUE].thumbnail.path)
        assertEquals(EXTENSION, charactersList[ZERO_VALUE].thumbnail.extension)
        assertEquals(MODIFIED, charactersList[ZERO_VALUE].modified)
        assertEquals(RESOURCEURI, charactersList[ZERO_VALUE].resourceUri)
        assertEquals(AVAILABLE, charactersList[ZERO_VALUE].comics.available)
        assertEquals(COLLECTIONURI, charactersList[ZERO_VALUE].comics.collectionURI)
        assertEquals(RETURNED, charactersList[ZERO_VALUE].comics.returned)
        assertEquals(AVAILABLE, charactersList[ZERO_VALUE].events.available)
        assertEquals(COLLECTIONURI, charactersList[ZERO_VALUE].events.collectionURI)
        assertEquals(RETURNED, charactersList[ZERO_VALUE].events.returned)
        assertEquals(AVAILABLE, charactersList[ZERO_VALUE].series.available)
        assertEquals(COLLECTIONURI, charactersList[ZERO_VALUE].series.collectionURI)
        assertEquals(RETURNED, charactersList[ZERO_VALUE].series.returned)
        assertEquals(AVAILABLE, charactersList[ZERO_VALUE].stories.available)
        assertEquals(COLLECTIONURI, charactersList[ZERO_VALUE].stories.collectionURI)
        assertEquals(RETURNED, charactersList[ZERO_VALUE].stories.returned)
    }
}

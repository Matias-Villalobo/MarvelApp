package com.example.marvelapp.data.mapper

import com.example.marvelapp.utils.CharactersConstantsUtils.AVAILABLE
import com.example.marvelapp.utils.CharactersConstantsUtils.CHARACTER_ENTITY
import com.example.marvelapp.utils.CharactersConstantsUtils.CHARACTER_REALM_ENTITY
import com.example.marvelapp.utils.CharactersConstantsUtils.COLLECTIONURI
import com.example.marvelapp.utils.CharactersConstantsUtils.DESCRIPTION
import com.example.marvelapp.utils.CharactersConstantsUtils.EXTENSION
import com.example.marvelapp.utils.CharactersConstantsUtils.ID
import com.example.marvelapp.utils.CharactersConstantsUtils.MODIFIED
import com.example.marvelapp.utils.CharactersConstantsUtils.NAME
import com.example.marvelapp.utils.CharactersConstantsUtils.PATH
import com.example.marvelapp.utils.CharactersConstantsUtils.RESOURCEURI
import com.example.marvelapp.utils.CharactersConstantsUtils.RETURNED
import com.example.marvelapp.utils.CharactersConstantsUtils.URL_LIST_ENTITY
import com.example.marvelapp.utils.CharactersConstantsUtils.URL_REALM_LIST_ENTITY
import com.example.marvelapp.utils.CharactersConstantsUtils.ZERO_VALUE
import org.junit.Assert.assertEquals
import org.junit.Test

class CharacterRealmMapperTest {

    @Test
    fun transformWhenValidValuesTest() {
        val actual = CharacterRealmMapper.transformDBCharacter(CHARACTER_ENTITY)
        assertEquals(ID, actual.id)
        assertEquals(NAME, actual.name)
        assertEquals(DESCRIPTION, actual.description)
        assertEquals(MODIFIED, actual.modified)
        assertEquals(PATH, actual.thumbnail?.path)
        assertEquals(EXTENSION, actual.thumbnail?.extension)
        assertEquals(RESOURCEURI, actual.resourceUri)
        assertEquals(AVAILABLE, actual.events?.available)
        assertEquals(COLLECTIONURI, actual.events?.collectionURI)
        assertEquals(RETURNED, actual.events?.returned)
        assertEquals(AVAILABLE, actual.stories?.available)
        assertEquals(COLLECTIONURI, actual.stories?.collectionURI)
        assertEquals(RETURNED, actual.stories?.returned)
        assertEquals(AVAILABLE, actual.series?.available)
        assertEquals(COLLECTIONURI, actual.series?.collectionURI)
        assertEquals(RETURNED, actual.series?.returned)
        assertEquals(AVAILABLE, actual.comics?.available)
        assertEquals(COLLECTIONURI, actual.comics?.collectionURI)
        assertEquals(RETURNED, actual.comics?.returned)
        assertEquals(RETURNED, actual.comics?.returned)
        assertEquals(URL_REALM_LIST_ENTITY[ZERO_VALUE]?.type, actual.urls[ZERO_VALUE]?.type)
        assertEquals(URL_REALM_LIST_ENTITY[ZERO_VALUE]?.url, actual.urls[ZERO_VALUE]?.url)
    }

    @Test
    fun transformToResponseTest() {
        val actual = CharacterRealmMapper.transformCharacterRealmToEntity(CHARACTER_REALM_ENTITY)
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
        assertEquals(URL_LIST_ENTITY[ZERO_VALUE].type, actual.urls[ZERO_VALUE].type)
        assertEquals(URL_LIST_ENTITY[ZERO_VALUE].url, actual.urls[ZERO_VALUE].url)
    }

    @Test
    fun transformEntityListToRealmListTest() {
        assertEquals(ZERO_VALUE, CharacterRealmMapper.transformEntityListToRealmList(emptyList()).size)
    }

    @Test
    fun transformRealmListToEntityListTest() {
        assertEquals(ZERO_VALUE, CharacterRealmMapper.transformRealmListToEntityList(emptyList()).size)
    }
}

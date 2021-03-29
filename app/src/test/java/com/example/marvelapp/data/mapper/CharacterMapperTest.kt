package com.example.marvelapp.data.mapper

import com.example.marvelapp.data.service.response.CharacterResponse
import com.example.marvelapp.data.service.response.ComicsResponse
import com.example.marvelapp.data.service.response.EventsResponse
import com.example.marvelapp.data.service.response.SeriesResponse
import com.example.marvelapp.data.service.response.StoriesResponse
import com.example.marvelapp.data.service.response.ThumbnailResponse
import com.example.marvelapp.data.service.response.UrlResponse
import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.entity.CharacterEntity
import com.nhaarman.mockitokotlin2.whenever
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class CharacterMapperTest {
    private val mockCharacterResponse = mock(CharacterResponse::class.java)
    private val mockThumbnailResponse = mock(ThumbnailResponse::class.java)
    private val mockComicsResponse = mock(ComicsResponse::class.java)
    private val mockUrlResponse = mock(UrlResponse::class.java)
    private val mockSeriesResponse = mock(SeriesResponse::class.java)
    private val mockStoriesResponse = mock(StoriesResponse::class.java)
    private val mockEventsResponse = mock(EventsResponse::class.java)
    private lateinit var mapper: CharacterMapper

    @Before
    fun setUp() {
        mapper = CharacterMapper
    }

    @Test
    fun validValuestest() {
        whenever(mockCharacterResponse.id).thenReturn(ID)
        whenever(mockCharacterResponse.name).thenReturn(NAME)
        whenever(mockCharacterResponse.description).thenReturn(DESCRIPTION)
        whenever(mockThumbnailResponse.path).thenReturn(PATH)
        whenever(mockThumbnailResponse.extension).thenReturn(EXTENSION)
        whenever(mockCharacterResponse.thumbnail).thenReturn(mockThumbnailResponse)
        whenever(mockCharacterResponse.modified).thenReturn(MODIFIED)
        whenever(mockCharacterResponse.resourceUri).thenReturn(RESOURCEURI)
        whenever(mockEventsResponse.available).thenReturn(AVAILABLE)
        whenever(mockEventsResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockEventsResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.events).thenReturn(mockEventsResponse)
        whenever(mockComicsResponse.available).thenReturn(AVAILABLE)
        whenever(mockComicsResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockComicsResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.comics).thenReturn(mockComicsResponse)
        whenever(mockStoriesResponse.available).thenReturn(AVAILABLE)
        whenever(mockStoriesResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockStoriesResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.stories).thenReturn(mockStoriesResponse)
        whenever(mockSeriesResponse.available).thenReturn(AVAILABLE)
        whenever(mockSeriesResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockSeriesResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.series).thenReturn(mockSeriesResponse)
        whenever(mockUrlResponse.url).thenReturn(URL)
        whenever(mockUrlResponse.type).thenReturn(TYPE)
        whenever(mockCharacterResponse.urls).thenReturn(listOf(mockUrlResponse))
        assertForValidValues(mapper.transformCharacter(mockCharacterResponse))
    }

    @Test
    fun transformSingleCharacter() {
        whenever(mockCharacterResponse.id).thenReturn(ID)
        whenever(mockCharacterResponse.name).thenReturn(NAME)
        whenever(mockCharacterResponse.description).thenReturn(DESCRIPTION)
        whenever(mockCharacterResponse.modified).thenReturn(MODIFIED)
        whenever(mockThumbnailResponse.path).thenReturn(PATH)
        whenever(mockThumbnailResponse.extension).thenReturn(EXTENSION)
        whenever(mockCharacterResponse.thumbnail).thenReturn(mockThumbnailResponse)
        whenever(mockCharacterResponse.resourceUri).thenReturn(RESOURCEURI)
        whenever(mockComicsResponse.available).thenReturn(AVAILABLE)
        whenever(mockComicsResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockComicsResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.comics).thenReturn(mockComicsResponse)
        whenever(mockEventsResponse.available).thenReturn(AVAILABLE)
        whenever(mockEventsResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockEventsResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.events).thenReturn(mockEventsResponse)
        whenever(mockStoriesResponse.available).thenReturn(AVAILABLE)
        whenever(mockStoriesResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockStoriesResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.stories).thenReturn(mockStoriesResponse)
        whenever(mockSeriesResponse.available).thenReturn(AVAILABLE)
        whenever(mockSeriesResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockSeriesResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.series).thenReturn(mockSeriesResponse)
        whenever(mockUrlResponse.url).thenReturn(URL)
        whenever(mockUrlResponse.type).thenReturn(TYPE)
        whenever(mockCharacterResponse.urls).thenReturn(listOf(mockUrlResponse))
        assertBufferDataResponseEquality(mapper.transformSingleCharacter(mockCharacterResponse))
    }

    private fun assertForValidValues(character: CharacterEntity) {
        assertEquals(ID, character.id)
        assertEquals(NAME, character.name)
        assertEquals(DESCRIPTION, character.description)
        assertEquals(PATH, character.thumbnail.path)
        assertEquals(EXTENSION, character.thumbnail.extension)
        assertEquals(AVAILABLE, character.comics.available)
        assertEquals(COLLECTIONURI, character.comics.collectionURI)
        assertEquals(RETURNED, character.comics.returned)
        assertEquals(AVAILABLE, character.series.available)
        assertEquals(COLLECTIONURI, character.series.collectionURI)
        assertEquals(RETURNED, character.series.returned)
        assertEquals(AVAILABLE, character.stories.available)
        assertEquals(COLLECTIONURI, character.stories.collectionURI)
        assertEquals(RETURNED, character.stories.returned)
        assertEquals(AVAILABLE, character.events.available)
        assertEquals(COLLECTIONURI, character.events.collectionURI)
        assertEquals(RETURNED, character.events.returned)
        assertEquals(MODIFIED, character.modified)
        assertEquals(RESOURCEURI, character.resourceUri)
    }

    private fun assertBufferDataResponseEquality(character: CharacterDetailEntity) {
        assertEquals(ID, character.id)
        assertEquals(NAME, character.name)
        assertEquals(DESCRIPTION, character.description)
        assertEquals(PATH, character.thumbnail.path)
        assertEquals(EXTENSION, character.thumbnail.extension)
        assertEquals(AVAILABLE, character.comics.available)
        assertEquals(COLLECTIONURI, character.comics.collectionURI)
        assertEquals(RETURNED, character.comics.returned)
        assertEquals(AVAILABLE, character.series.available)
        assertEquals(COLLECTIONURI, character.series.collectionURI)
        assertEquals(RETURNED, character.series.returned)
        assertEquals(AVAILABLE, character.stories.available)
        assertEquals(COLLECTIONURI, character.stories.collectionURI)
        assertEquals(RETURNED, character.stories.returned)
        assertEquals(AVAILABLE, character.events.available)
        assertEquals(COLLECTIONURI, character.events.collectionURI)
        assertEquals(RETURNED, character.events.returned)
        assertEquals(MODIFIED, character.modified)
        assertEquals(RESOURCEURI, character.resourceUri)
    }

    @Test
    fun transformListoOfCharactersEmptyTest() {
        assertEquals(0, mapper.transformListOfCharacters(emptyList()).size)
    }

    @Test
    fun transformListoOfCharactersTest() {
        whenever(mockCharacterResponse.id).thenReturn(ID)
        whenever(mockCharacterResponse.name).thenReturn(NAME)
        whenever(mockCharacterResponse.description).thenReturn(DESCRIPTION)
        whenever(mockThumbnailResponse.path).thenReturn(PATH)
        whenever(mockThumbnailResponse.extension).thenReturn(EXTENSION)
        whenever(mockCharacterResponse.thumbnail).thenReturn(mockThumbnailResponse)
        whenever(mockCharacterResponse.modified).thenReturn(MODIFIED)
        whenever(mockCharacterResponse.resourceUri).thenReturn(RESOURCEURI)
        whenever(mockEventsResponse.available).thenReturn(AVAILABLE)
        whenever(mockEventsResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockEventsResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.events).thenReturn(mockEventsResponse)
        whenever(mockComicsResponse.available).thenReturn(AVAILABLE)
        whenever(mockComicsResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockComicsResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.comics).thenReturn(mockComicsResponse)
        whenever(mockStoriesResponse.available).thenReturn(AVAILABLE)
        whenever(mockStoriesResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockStoriesResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.stories).thenReturn(mockStoriesResponse)
        whenever(mockSeriesResponse.available).thenReturn(AVAILABLE)
        whenever(mockSeriesResponse.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockSeriesResponse.returned).thenReturn(RETURNED)
        whenever(mockCharacterResponse.series).thenReturn(mockSeriesResponse)

        val charactersList = mapper.transformListOfCharacters(listOf(mockCharacterResponse))

        assertEquals(1, charactersList.size)
        assertEquals(ID, charactersList[0].id)
        assertEquals(NAME, charactersList[0].name)
        assertEquals(DESCRIPTION, charactersList[0].description)
        assertEquals(PATH, charactersList[0].thumbnail.path)
        assertEquals(EXTENSION, charactersList[0].thumbnail.extension)
        assertEquals(MODIFIED, charactersList[0].modified)
        assertEquals(RESOURCEURI, charactersList[0].resourceUri)
        assertEquals(AVAILABLE, charactersList[0].comics.available)
        assertEquals(COLLECTIONURI, charactersList[0].comics.collectionURI)
        assertEquals(RETURNED, charactersList[0].comics.returned)
        assertEquals(AVAILABLE, charactersList[0].events.available)
        assertEquals(COLLECTIONURI, charactersList[0].events.collectionURI)
        assertEquals(RETURNED, charactersList[0].events.returned)
        assertEquals(AVAILABLE, charactersList[0].series.available)
        assertEquals(COLLECTIONURI, charactersList[0].series.collectionURI)
        assertEquals(RETURNED, charactersList[0].series.returned)
        assertEquals(AVAILABLE, charactersList[0].stories.available)
        assertEquals(COLLECTIONURI, charactersList[0].stories.collectionURI)
        assertEquals(RETURNED, charactersList[0].stories.returned)
    }

    companion object {
        private const val ID = 1234567
        private const val NAME = "requeterico"
        private const val DESCRIPTION = "we are the champions"
        private const val PATH = "http:/ricoco.com/"
        private const val EXTENSION = ".PNG"
        private const val MODIFIED = "2014-04-29T14:18:17-0400"
        private const val RESOURCEURI = "http:/rerico.com/"
        private const val AVAILABLE = 2
        private const val COLLECTIONURI = "http:/rericomarvel.com/"
        private const val RETURNED = 4
        private const val TYPE = "lll"
        private const val URL = "www"
    }
}

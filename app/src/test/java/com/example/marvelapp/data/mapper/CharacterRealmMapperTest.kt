package com.example.marvelapp.data.mapper

import com.example.marvelapp.data.local.model.CharacterRealmEntity
import com.example.marvelapp.data.local.model.ComicsRealmEntity
import com.example.marvelapp.data.local.model.EventsRealmEntity
import com.example.marvelapp.data.local.model.SeriesRealmEntity
import com.example.marvelapp.data.local.model.StoriesRealmEntity
import com.example.marvelapp.data.local.model.ThumbnailRealmEntity
import com.example.marvelapp.data.local.model.UrlRealmEntity
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.entity.ComicsEntity
import com.example.marvelapp.domain.entity.EventsEntity
import com.example.marvelapp.domain.entity.SeriesEntity
import com.example.marvelapp.domain.entity.StoriesEntity
import com.example.marvelapp.domain.entity.ThumbnailEntity
import com.example.marvelapp.domain.entity.UrlEntity
import com.nhaarman.mockitokotlin2.whenever
import io.realm.RealmList
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock

class CharacterRealmMapperTest {
    private val mockCharacterEntity = mock(CharacterEntity::class.java)
    private val mockCharacterRealmEntity = mock(CharacterRealmEntity::class.java)
    private val mockThumbnailRealmEntity = mock(ThumbnailRealmEntity::class.java)
    private val mockThumbnailEntity = mock(ThumbnailEntity::class.java)
    private val mockUrlEntity = mock(UrlEntity::class.java)
    private val mockUrlRealmEntity = mock(UrlRealmEntity::class.java)
    private val mockUrlRealmEntityList = RealmList(UrlRealmEntity(TYPE, URL))
    private val mockEventsRealmEntity = mock(EventsRealmEntity::class.java)
    private val mockEventsEntity = mock(EventsEntity::class.java)
    private val mockComicsRealmEntity = mock(ComicsRealmEntity::class.java)
    private val mockComicsEntity = mock(ComicsEntity::class.java)
    private val mockSeriesRealmEntity = mock(SeriesRealmEntity::class.java)
    private val mockSeriesEntity = mock(SeriesEntity::class.java)
    private val mockStoriesRealmEntity = mock(StoriesRealmEntity::class.java)
    private val mockStoriesEntity = mock(StoriesEntity::class.java)
    private lateinit var mapper: CharacterRealmMapper

    @Before
    fun setUp() {
        mapper = CharacterRealmMapper
    }

    @Test
    fun transformWhenValidValuesTest() {
        whenever(mockCharacterEntity.id).thenReturn(ID)
        whenever(mockCharacterEntity.name).thenReturn(NAME)
        whenever(mockCharacterEntity.description).thenReturn(DESCRIPTION)
        whenever(mockThumbnailEntity.path).thenReturn(PATH)
        whenever(mockThumbnailEntity.extension).thenReturn(EXTENSION)
        whenever(mockCharacterEntity.thumbnail).thenReturn(mockThumbnailEntity)
        whenever(mockComicsEntity.available).thenReturn(AVAILABLE)
        whenever(mockComicsEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockComicsEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterEntity.comics).thenReturn(mockComicsEntity)
        whenever(mockEventsEntity.available).thenReturn(AVAILABLE)
        whenever(mockEventsEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockEventsEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterEntity.events).thenReturn(mockEventsEntity)
        whenever(mockSeriesEntity.available).thenReturn(AVAILABLE)
        whenever(mockSeriesEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockSeriesEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterEntity.series).thenReturn(mockSeriesEntity)
        whenever(mockStoriesEntity.available).thenReturn(AVAILABLE)
        whenever(mockStoriesEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockStoriesEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterEntity.stories).thenReturn(mockStoriesEntity)
        whenever(mockCharacterEntity.modified).thenReturn(MODIFIED)
        whenever(mockCharacterEntity.resourceUri).thenReturn(RESOURCEURI)
        assertValidValues(mapper.transformDBCharacter(mockCharacterEntity))
    }

    @Test
    fun testNullValuesTest() {
        whenever(mockCharacterRealmEntity.id).thenReturn(ID)
        whenever(mockCharacterRealmEntity.name).thenReturn(NAME)
        whenever(mockCharacterRealmEntity.description).thenReturn(DESCRIPTION)
        whenever(mockCharacterRealmEntity.thumbnail).thenReturn(NULL_VALUE)
        whenever(mockCharacterRealmEntity.comics).thenReturn(NULL_VALUE)
        whenever(mockCharacterRealmEntity.events).thenReturn(NULL_VALUE)
        whenever(mockCharacterRealmEntity.series).thenReturn(NULL_VALUE)
        whenever(mockCharacterRealmEntity.stories).thenReturn(NULL_VALUE)
        whenever(mockCharacterRealmEntity.modified).thenReturn(MODIFIED)
        whenever(mockCharacterRealmEntity.resourceUri).thenReturn(RESOURCEURI)
        whenever(mockUrlRealmEntity.url).thenReturn(URL)
        whenever(mockUrlRealmEntity.type).thenReturn(TYPE)
        whenever(mockCharacterRealmEntity.urls).thenReturn(mockUrlRealmEntityList)
        assertForNullValues(mapper.transformCharacterRealmToEntity(mockCharacterRealmEntity))
    }

    @Test
    fun transformToResponseTest() {
        whenever(mockCharacterRealmEntity.id).thenReturn(ID)
        whenever(mockCharacterRealmEntity.name).thenReturn(NAME)
        whenever(mockCharacterRealmEntity.description).thenReturn(DESCRIPTION)
        whenever(mockThumbnailRealmEntity.path).thenReturn(PATH)
        whenever(mockThumbnailRealmEntity.extension).thenReturn(EXTENSION)
        whenever(mockCharacterRealmEntity.thumbnail).thenReturn(mockThumbnailRealmEntity)
        whenever(mockComicsRealmEntity.available).thenReturn(AVAILABLE)
        whenever(mockComicsRealmEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockComicsRealmEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterRealmEntity.comics).thenReturn(mockComicsRealmEntity)
        whenever(mockEventsRealmEntity.available).thenReturn(AVAILABLE)
        whenever(mockEventsRealmEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockEventsRealmEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterRealmEntity.events).thenReturn(mockEventsRealmEntity)
        whenever(mockSeriesRealmEntity.available).thenReturn(AVAILABLE)
        whenever(mockSeriesRealmEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockSeriesRealmEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterRealmEntity.series).thenReturn(mockSeriesRealmEntity)
        whenever(mockStoriesRealmEntity.available).thenReturn(AVAILABLE)
        whenever(mockStoriesRealmEntity.collectionURI).thenReturn(COLLECTIONURI)
        whenever(mockStoriesRealmEntity.returned).thenReturn(RETURNED)
        whenever(mockCharacterRealmEntity.stories).thenReturn(mockStoriesRealmEntity)
        whenever(mockCharacterRealmEntity.modified).thenReturn(MODIFIED)
        whenever(mockCharacterRealmEntity.resourceUri).thenReturn(RESOURCEURI)
        whenever(mockCharacterRealmEntity.urls).thenReturn(RealmList(UrlRealmEntity()))
        assertForRealm(mapper.transformCharacterRealmToEntity(mockCharacterRealmEntity))
    }

    private fun assertForRealm(character: CharacterEntity) {
        assertEquals(ID, character.id)
        assertEquals(NAME, character.name)
        assertEquals(DESCRIPTION, character.description)
        assertEquals(PATH, character.thumbnail.path)
        assertEquals(EXTENSION, character.thumbnail.extension)
        assertEquals(AVAILABLE, character.comics.available)
        assertEquals(COLLECTIONURI, character.comics.collectionURI)
        assertEquals(RETURNED, character.comics.returned)
        assertEquals(AVAILABLE, character.events.available)
        assertEquals(COLLECTIONURI, character.events.collectionURI)
        assertEquals(RETURNED, character.events.returned)
        assertEquals(AVAILABLE, character.series.available)
        assertEquals(COLLECTIONURI, character.series.collectionURI)
        assertEquals(RETURNED, character.series.returned)
        assertEquals(AVAILABLE, character.stories.available)
        assertEquals(COLLECTIONURI, character.stories.collectionURI)
        assertEquals(RETURNED, character.stories.returned)
        assertEquals(MODIFIED, character.modified)
        assertEquals(RESOURCEURI, character.resourceUri)
    }

    private fun assertForNullValues(character: CharacterEntity) {
        assertEquals(EMPTY_VALUE, character.thumbnail.extension)
        assertEquals(EMPTY_VALUE, character.thumbnail.path)
        assertEquals(EMPTY_VALUE, character.comics.collectionURI)
        assertEquals(ZERO_VALUE, character.comics.available)
        assertEquals(ZERO_VALUE, character.comics.returned)
        assertEquals(EMPTY_VALUE, character.series.collectionURI)
        assertEquals(ZERO_VALUE, character.series.available)
        assertEquals(ZERO_VALUE, character.series.returned)
        assertEquals(EMPTY_VALUE, character.events.collectionURI)
        assertEquals(ZERO_VALUE, character.events.available)
        assertEquals(ZERO_VALUE, character.events.returned)
        assertEquals(EMPTY_VALUE, character.stories.collectionURI)
        assertEquals(ZERO_VALUE, character.stories.available)
        assertEquals(ZERO_VALUE, character.stories.returned)
    }

    private fun assertValidValues(character: CharacterRealmEntity) {
        assertEquals(ID, character.id)
        assertEquals(NAME, character.name)
        assertEquals(DESCRIPTION, character.description)
        assertEquals(PATH, character.thumbnail?.path)
        assertEquals(EXTENSION, character.thumbnail?.extension)
        assertEquals(AVAILABLE, character.comics?.available)
        assertEquals(COLLECTIONURI, character.comics?.collectionURI)
        assertEquals(RETURNED, character.comics?.returned)
        assertEquals(AVAILABLE, character.events?.available)
        assertEquals(COLLECTIONURI, character.events?.collectionURI)
        assertEquals(RETURNED, character.events?.returned)
        assertEquals(AVAILABLE, character.series?.available)
        assertEquals(COLLECTIONURI, character.series?.collectionURI)
        assertEquals(RETURNED, character.series?.returned)
        assertEquals(AVAILABLE, character.stories?.available)
        assertEquals(COLLECTIONURI, character.stories?.collectionURI)
        assertEquals(RETURNED, character.stories?.returned)
        assertEquals(MODIFIED, character.modified)
        assertEquals(RESOURCEURI, character.resourceUri)
    }

    @Test
    fun transformURLTest() {
        whenever(mockUrlRealmEntity.type).thenReturn(TYPE)
        whenever(mockUrlRealmEntity.url).thenReturn(URL)
        assertUrlEquality(mapper.transformRealmToEntity(mockUrlRealmEntity))
    }

    private fun assertUrlEquality(url: UrlEntity) {
        assertEquals(TYPE, url.type)
        assertEquals(URL, url.url)
    }

    @Test
    fun transformURLtoRealmTest() {
        whenever(mockUrlEntity.type).thenReturn(TYPE)
        whenever(mockUrlEntity.url).thenReturn(URL)
        assertUrlEqualityRealm(mapper.transformDBUrl(mockUrlEntity))
    }

    private fun assertUrlEqualityRealm(urls: UrlRealmEntity) {
        assertEquals(TYPE, urls.type)
        assertEquals(URL, urls.url)
    }

    @Test
    fun transformListoOfCharactersEmptyTest() {
        assertEquals(0, mapper.transformToUrlList(emptyList()).size)
    }

    @Test
    fun transformRealmListoOfCharactersEmptyTest() {
        assertEquals(0, mapper.transformRealmListToEntityList(emptyList()).size)
    }

    companion object {
        private const val ID = 1234567
        private const val NAME = "requeterico"
        private const val DESCRIPTION = "we are the champions"
        private const val PATH = "http:/ricoco.com/"
        private const val EXTENSION = ".PNG"
        private const val MODIFIED = "2014-04-29T14:18:17-0400"
        private const val RESOURCEURI = "http:/rerico.com/"
        private const val TYPE = "lll"
        private const val URL = "www"
        private const val RETURNED = 4
        private const val AVAILABLE = 2
        private const val COLLECTIONURI = "http:/rericomarvel.com/"
        private const val EMPTY_VALUE = ""
        private const val ZERO_VALUE = 0
        private val NULL_VALUE = null
    }
}

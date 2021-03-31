package com.example.marvelapp.utils

import com.example.marvelapp.data.local.model.CharacterRealmEntity
import com.example.marvelapp.data.local.model.ComicsRealmEntity
import com.example.marvelapp.data.local.model.EventsRealmEntity
import com.example.marvelapp.data.local.model.SeriesRealmEntity
import com.example.marvelapp.data.local.model.StoriesRealmEntity
import com.example.marvelapp.data.local.model.ThumbnailRealmEntity
import com.example.marvelapp.data.local.model.UrlRealmEntity
import com.example.marvelapp.data.service.response.CharacterResponse
import com.example.marvelapp.data.service.response.ComicsResponse
import com.example.marvelapp.data.service.response.EventsResponse
import com.example.marvelapp.data.service.response.SeriesResponse
import com.example.marvelapp.data.service.response.StoriesResponse
import com.example.marvelapp.data.service.response.ThumbnailResponse
import com.example.marvelapp.data.service.response.UrlResponse
import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.entity.ComicsEntity
import com.example.marvelapp.domain.entity.EventsEntity
import com.example.marvelapp.domain.entity.SeriesEntity
import com.example.marvelapp.domain.entity.StoriesEntity
import com.example.marvelapp.domain.entity.ThumbnailEntity
import com.example.marvelapp.domain.entity.UrlEntity
import io.realm.RealmList

object CharactersConstantsUtils {
    const val ID = 1234567
    const val NAME = "GlobantMan"
    const val DESCRIPTION = "the best hero"
    const val PATH = "http:/marvel.com/"
    const val EXTENSION = ".PNG"
    const val MODIFIED = "2014-04-29T14:18:17-0400"
    const val RESOURCEURI = "http:/hero.com/"
    const val TYPE = "lll"
    const val URL = "www.marvelHeroes.com"
    const val RETURNED = 4
    const val AVAILABLE = 2
    const val COLLECTIONURI = "http:/marvelcollection.com/"
    const val EMPTY_VALUE = ""
    const val ZERO_VALUE = 0
    const val ONE_VALUE = 1
    val EVENTS_ENTITY = EventsEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val THUMBNAIL_ENTITY = ThumbnailEntity(PATH, EXTENSION)
    val COMICS_ENTITY = ComicsEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val SERIES_ENTITY = SeriesEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val STORIES_ENTITY = StoriesEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val URL_LIST_ENTITY = listOf(UrlEntity(TYPE, URL))
    val URL_REALM_LIST_ENTITY = RealmList(UrlRealmEntity(TYPE, URL))
    val EVENTS_REALM_ENTITY = EventsRealmEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val THUMBNAIL_REALM_ENTITY = ThumbnailRealmEntity(PATH, EXTENSION)
    val COMICS_REALM_ENTITY = ComicsRealmEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val SERIES_REALM_ENTITY = SeriesRealmEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val STORIES_REALM_ENTITY = StoriesRealmEntity(AVAILABLE, COLLECTIONURI, RETURNED)
    val EVENTS_RESPONSE = EventsResponse(AVAILABLE, COLLECTIONURI, RETURNED)
    val THUMBNAIL_RESPONSE = ThumbnailResponse(PATH, EXTENSION)
    val COMICS_RESPONSE = ComicsResponse(AVAILABLE, COLLECTIONURI, RETURNED)
    val SERIES_RESPONSE = SeriesResponse(AVAILABLE, COLLECTIONURI, RETURNED)
    val STORIES_RESPONSE = StoriesResponse(AVAILABLE, COLLECTIONURI, RETURNED)
    val URL_LIST_RESPONSE = listOf(UrlResponse(TYPE, URL))

    val CHARACTER_ENTITY = CharacterEntity(
        ID, NAME, DESCRIPTION, MODIFIED, THUMBNAIL_ENTITY, RESOURCEURI,
        EVENTS_ENTITY, COMICS_ENTITY, STORIES_ENTITY, SERIES_ENTITY, URL_LIST_ENTITY
    )
    val CHARACTER_DETAIL_ENTITY = CharacterDetailEntity(
        ID, NAME, DESCRIPTION, MODIFIED, THUMBNAIL_ENTITY, RESOURCEURI,
        COMICS_ENTITY, EVENTS_ENTITY, STORIES_ENTITY, SERIES_ENTITY, URL_LIST_ENTITY
    )
    val CHARACTER_REALM_ENTITY = CharacterRealmEntity(
        ID, NAME, DESCRIPTION, MODIFIED, THUMBNAIL_REALM_ENTITY, RESOURCEURI, COMICS_REALM_ENTITY,
        EVENTS_REALM_ENTITY, STORIES_REALM_ENTITY, SERIES_REALM_ENTITY, URL_REALM_LIST_ENTITY
    )
    val CHARACTER_RESPONSE = CharacterResponse(
        ID, NAME, DESCRIPTION, MODIFIED, THUMBNAIL_RESPONSE, RESOURCEURI,
        COMICS_RESPONSE, URL_LIST_RESPONSE, SERIES_RESPONSE, STORIES_RESPONSE, EVENTS_RESPONSE
    )
}

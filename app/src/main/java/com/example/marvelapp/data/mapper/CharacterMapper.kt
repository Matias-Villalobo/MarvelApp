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
import com.example.marvelapp.domain.entity.ComicsEntity
import com.example.marvelapp.domain.entity.EventsEntity
import com.example.marvelapp.domain.entity.SeriesEntity
import com.example.marvelapp.domain.entity.StoriesEntity
import com.example.marvelapp.domain.entity.ThumbnailEntity
import com.example.marvelapp.domain.entity.UrlEntity

object CharacterMapper {

     fun transformCharacter(characterResponse: CharacterResponse): CharacterEntity =
        CharacterEntity(
            characterResponse.id,
            characterResponse.name,
            characterResponse.description,
            characterResponse.modified,
            transformThumbnail(characterResponse.thumbnail),
            characterResponse.resourceUri,
            transformEvents(characterResponse.events),
            transformComics(characterResponse.comics),
            transformStories(characterResponse.stories),
            transformSeries(characterResponse.series),
            transformListOfUrls(characterResponse.urls)
        )

    fun transformSingleCharacter(character: CharacterResponse): CharacterDetailEntity =
        CharacterDetailEntity(
            character.id,
            character.name,
            character.description,
            character.modified,
            transformThumbnail(character.thumbnail),
            character.resourceUri,
            transformComics(character.comics),
            transformEvents(character.events),
            transformStories(character.stories),
            transformSeries(character.series),
            transformListOfUrls(character.urls)
        )

    private fun transformUrl(urlResponse: UrlResponse): UrlEntity = UrlEntity(
        urlResponse.type,
        urlResponse.url
    )

    fun transformListOfUrls(urlResponse: List<UrlResponse>): List<UrlEntity> =
        urlResponse.map { transformUrl(it) }

    private fun transformThumbnail(thumbnailResponse: ThumbnailResponse): ThumbnailEntity =
        ThumbnailEntity(
            thumbnailResponse.path,
            thumbnailResponse.extension
        )

    private fun transformComics(comicsResponse: ComicsResponse): ComicsEntity = ComicsEntity(
        comicsResponse.available,
        comicsResponse.collectionURI,
        comicsResponse.returned
    )

    private fun transformEvents(eventsResponse: EventsResponse): EventsEntity = EventsEntity(
        eventsResponse.available,
        eventsResponse.collectionURI,
        eventsResponse.returned
    )

    private fun transformSeries(seriesResponse: SeriesResponse): SeriesEntity = SeriesEntity(
        seriesResponse.available,
        seriesResponse.collectionURI,
        seriesResponse.returned
    )

    private fun transformStories(storiesResponse: StoriesResponse): StoriesEntity = StoriesEntity(
        storiesResponse.available,
        storiesResponse.collectionURI,
        storiesResponse.returned
    )

    fun transformListOfCharacters(charactersResponse: List<CharacterResponse>): List<CharacterEntity> =
        charactersResponse.map { transformCharacter(it) }
}

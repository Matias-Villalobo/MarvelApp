package com.example.marvelapp.data.mapper

import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.entity.UrlsEntity
import com.example.marvelapp.domain.entity.ThumbnailEntity
import com.example.marvelapp.domain.entity.ComicsEntity
import com.example.marvelapp.domain.entity.EventsEntity
import com.example.marvelapp.domain.entity.SeriesEntity
import com.example.marvelapp.domain.entity.StoriesEntity
import com.example.marvelapp.data.service.response.CharacterResponse
import com.example.marvelapp.data.service.response.UrlResponse
import com.example.marvelapp.data.service.response.ThumbnailResponse
import com.example.marvelapp.data.service.response.ComicsResponse
import com.example.marvelapp.data.service.response.EventsResponse
import com.example.marvelapp.data.service.response.SeriesResponse
import com.example.marvelapp.data.service.response.StoriesResponse

object CharacterMapper {

    private fun transformCharacter(characterResponse: CharacterResponse): CharacterEntity =
        CharacterEntity(
            characterResponse.id,
            characterResponse.name,
            characterResponse.description,
            characterResponse.modified,
            transformThumbnail(characterResponse.thumbnail),
            transformEvents(characterResponse.events),
            transformComics(characterResponse.comics),
            transformStories(characterResponse.stories),
            transformSeries(characterResponse.series),
            transformListOfUrls(characterResponse.urls)
        )

    private fun transformUrl(urlResponse: UrlResponse): UrlsEntity = UrlsEntity(
        urlResponse.type,
        urlResponse.url
    )

    fun transformListOfUrls(urlResponse: List<UrlResponse>): List<UrlsEntity> =
        urlResponse.map { transformUrl(it) }

    private fun transformThumbnail(thumbnailResponse: ThumbnailResponse): ThumbnailEntity =
        ThumbnailEntity(
            thumbnailResponse.path,
            thumbnailResponse.extension
        )

    private fun transformComics(comicsResponse: ComicsResponse): ComicsEntity = ComicsEntity(
        comicsResponse.available,
    )

    private fun transformEvents(eventsResponse: EventsResponse): EventsEntity = EventsEntity(
        eventsResponse.available,
    )

    private fun transformSeries(seriesResponse: SeriesResponse): SeriesEntity = SeriesEntity(
        seriesResponse.available,
    )

    private fun transformStories(storiesResponse: StoriesResponse): StoriesEntity = StoriesEntity(
        storiesResponse.available,
    )

    fun transformListOfCharacters(charactersResponse: List<CharacterResponse>): List<CharacterEntity> =
        charactersResponse.map { transformCharacter(it) }
}

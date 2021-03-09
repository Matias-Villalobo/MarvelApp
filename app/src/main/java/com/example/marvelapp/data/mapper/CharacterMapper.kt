package com.example.marvelapp.data.mapper

import com.example.marvelapp.data.service.response.*
import com.example.marvelapp.domain.entity.*

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

    fun transformSingleCharacter(character: CharacterDetailResponse): CharacterDetailEntity =
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
            transformListOfUrls(character.urls),
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

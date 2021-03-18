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
import com.example.marvelapp.domain.entity.UrlsEntity
import io.realm.RealmList

object CharacterRealmMapper {

    private fun transformDBCharacter(characterEntity: CharacterEntity): CharacterRealmEntity =
        CharacterRealmEntity(
            characterEntity.id,
            characterEntity.name,
            characterEntity.description,
            characterEntity.modified,
            transformDBThumbnail(characterEntity.thumbnail),
            characterEntity.resourceUri,
            transformDBComics(characterEntity.comics),
            transformDBEvents(characterEntity.events),
            transformDBStories(characterEntity.stories),
            transformDBSeries(characterEntity.series),
            transformDBListOfUrls(characterEntity.urls)
        )

    fun transformDBListOfUrls(urlsEntity: List<UrlsEntity>): RealmList<UrlRealmEntity> {
        var list = urlsEntity.map { transformDBUrl(it) }
        var auxRealmList = RealmList<UrlRealmEntity>()
        list.forEach { auxRealmList.add(it) }
        return auxRealmList
    }

    private fun transformToUrlRealmEntity(url: UrlsEntity): UrlRealmEntity = UrlRealmEntity(
        url.type,
        url.url
    )

    private fun transformDBUrl(urlsEntity: UrlsEntity): UrlRealmEntity = UrlRealmEntity(
        urlsEntity.type,
        urlsEntity.url
    )

    private fun transformDBStories(storiesEntity: StoriesEntity): StoriesRealmEntity = StoriesRealmEntity(
        storiesEntity.available,
        storiesEntity.collectionURI,
        storiesEntity.returned
    )

    private fun transformDBThumbnail(thumbnailEntity: ThumbnailEntity): ThumbnailRealmEntity =
        ThumbnailRealmEntity(
            thumbnailEntity.path,
            thumbnailEntity.extension
        )

    private fun transformDBComics(comicsEntity: ComicsEntity): ComicsRealmEntity = ComicsRealmEntity(
        comicsEntity.available,
        comicsEntity.collectionURI,
        comicsEntity.returned
    )

    private fun transformDBEvents(eventsEntity: EventsEntity): EventsRealmEntity = EventsRealmEntity(
        eventsEntity.available,
        eventsEntity.collectionURI,
        eventsEntity.returned
    )

    private fun transformDBSeries(seriesEntity: SeriesEntity): SeriesRealmEntity = SeriesRealmEntity(
        seriesEntity.available,
        seriesEntity.collectionURI,
        seriesEntity.returned
    )

    fun transformDBListOfCharacters(charactersList: List<CharacterEntity>): List<CharacterRealmEntity> =
        charactersList.map { CharacterRealmMapper.transformDBCharacter(it) }
}

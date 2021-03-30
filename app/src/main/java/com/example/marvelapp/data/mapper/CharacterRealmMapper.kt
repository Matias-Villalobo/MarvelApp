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
import io.realm.RealmList

object CharacterRealmMapper {

    fun transformDBCharacter(characterEntity: CharacterEntity): CharacterRealmEntity = CharacterRealmEntity(
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

    fun transformCharacterRealmToEntity(characterRealmEntity: CharacterRealmEntity): CharacterEntity =
        CharacterEntity(
            characterRealmEntity.id,
            characterRealmEntity.name,
            characterRealmEntity.description,
            characterRealmEntity.modified,
            transformDBThumbnailr(characterRealmEntity.thumbnail),
            characterRealmEntity.resourceUri,
            transformDBEventsr(characterRealmEntity.events),
            transformDBComicsr(characterRealmEntity.comics),
            transformDBStoriesr(characterRealmEntity.stories),
            transformDBSeriesr(characterRealmEntity.series),
            transformToUrlList(characterRealmEntity.urls)
        )

    private fun transformDBStoriesr(storiesRealmEntity: StoriesRealmEntity?): StoriesEntity {
        storiesRealmEntity?.let {
            return StoriesEntity(
                storiesRealmEntity.available,
                storiesRealmEntity.collectionURI,
                storiesRealmEntity.returned
            )
        }
        return StoriesEntity()
    }

    private fun transformDBThumbnailr(thumbnailRealmEntity: ThumbnailRealmEntity?): ThumbnailEntity {
        thumbnailRealmEntity?.let {
            return ThumbnailEntity(
                thumbnailRealmEntity.path,
                thumbnailRealmEntity.extension
            )
        }
        return ThumbnailEntity()
    }

    private fun transformDBComicsr(comicsRealmEntity: ComicsRealmEntity?): ComicsEntity {
        comicsRealmEntity?.let {
            return ComicsEntity(
                comicsRealmEntity.available,
                comicsRealmEntity.collectionURI,
                comicsRealmEntity.returned
            )
        }
        return ComicsEntity()
    }

    private fun transformDBEventsr(eventsRealmEntity: EventsRealmEntity?): EventsEntity {
        eventsRealmEntity?.let {
            return EventsEntity(
                eventsRealmEntity.available,
                eventsRealmEntity.collectionURI,
                eventsRealmEntity.returned
            )
        }
        return EventsEntity()
    }

    private fun transformDBSeriesr(seriesRealmEntity: SeriesRealmEntity?): SeriesEntity {
        seriesRealmEntity?.let {
            return SeriesEntity(
                seriesRealmEntity.available,
                seriesRealmEntity.collectionURI,
                seriesRealmEntity.returned
            )
        }
        return SeriesEntity()
    }

    private fun transformDBListOfUrls(urlEntity: List<UrlEntity>): RealmList<UrlRealmEntity> {
        var list = urlEntity.map { transformDBUrl(it) }
        var auxRealmList = RealmList<UrlRealmEntity>()
        list.forEach { auxRealmList.add(it) }
        return auxRealmList
    }

    private fun transformToUrlList(urlRealmEntity: List<UrlRealmEntity>): List<UrlEntity> =
        urlRealmEntity.map { transformRealmToEntity(it) }

    private fun transformRealmToEntity(urlRealmEntity: UrlRealmEntity): UrlEntity = UrlEntity(
        urlRealmEntity.type,
        urlRealmEntity.url
    )

    private fun transformDBUrl(urlEntity: UrlEntity): UrlRealmEntity = UrlRealmEntity(
        urlEntity.type,
        urlEntity.url
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

    fun transformEntityListToRealmList(charactersList: List<CharacterEntity>): List<CharacterRealmEntity> =
        charactersList.map { transformDBCharacter(it) }

    fun transformRealmListToEntityList(charactersList: List<CharacterRealmEntity>): List<CharacterEntity> =
        charactersList.map { transformCharacterRealmToEntity(it) }
}

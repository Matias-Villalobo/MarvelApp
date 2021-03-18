package com.example.marvelapp.data.local.model

import com.example.marvelapp.data.local.model.utils.ConstantsUtils.VALUE_ZERO
import com.example.marvelapp.data.local.model.utils.ConstantsUtils.EMPTY_STRING
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CharacterRealmEntity(
    @PrimaryKey
    var id: Int = VALUE_ZERO,
    var name: String = EMPTY_STRING,
    var description: String = EMPTY_STRING,
    var modified: String = EMPTY_STRING,
    var thumbnail: ThumbnailRealmEntity? = ThumbnailRealmEntity(),
    var resourceUri: String = EMPTY_STRING,
    var comics: ComicsRealmEntity? = ComicsRealmEntity(),
    var events: EventsRealmEntity? = EventsRealmEntity(),
    var stories: StoriesRealmEntity? = StoriesRealmEntity(),
    var series: SeriesRealmEntity? = SeriesRealmEntity(),
    var urls: RealmList<UrlRealmEntity> = RealmList()
) : RealmObject()

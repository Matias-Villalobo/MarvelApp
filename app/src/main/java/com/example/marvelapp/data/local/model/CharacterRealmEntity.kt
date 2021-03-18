package com.example.marvelapp.data.local.model

import com.example.marvelapp.data.local.model.utils.NumbersUtils.VALUE_ZERO
import com.example.marvelapp.data.local.model.utils.StringUtils.EMPTY_STRING
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CharacterRealmEntity(
    @PrimaryKey
    var id: Int = VALUE_ZERO,
    var name: String = EMPTY_STRING,
    var description: String = EMPTY_STRING,
    var modified: String = EMPTY_STRING,
    var thumbnail: ThumbnailRealmEntity? = ThumbnailRealmEntity(EMPTY_STRING, EMPTY_STRING),
    var resourceUri: String = EMPTY_STRING,
    var comics: ComicsRealmEntity? = ComicsRealmEntity(VALUE_ZERO, EMPTY_STRING, VALUE_ZERO),
    var events: EventsRealmEntity? = EventsRealmEntity(VALUE_ZERO, EMPTY_STRING, VALUE_ZERO),
    var stories: StoriesRealmEntity? = StoriesRealmEntity(VALUE_ZERO, EMPTY_STRING, VALUE_ZERO),
    var series: SeriesRealmEntity? = SeriesRealmEntity(VALUE_ZERO, EMPTY_STRING, VALUE_ZERO),
    var urls: RealmList<UrlRealmEntity> = RealmList()
) : RealmObject()

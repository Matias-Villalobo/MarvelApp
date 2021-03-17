package com.example.marvelapp.data.local.model

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CharacterRealmEntity(
    @PrimaryKey
    var id: Int = 0,
    var name: String = "",
    var description: String = "",
    var modified: String = "",
    var thumbnail: ThumbnailRealmEntity? = ThumbnailRealmEntity("", ""),
    var resourceUri: String = "",
    var comics: ComicsRealmEntity? = ComicsRealmEntity(0, "", 0),
    var events: EventsRealmEntity? = EventsRealmEntity(0, "", 0),
    var stories: StoriesRealmEntity? = StoriesRealmEntity(0, "", 0),
    var series: SeriesRealmEntity? = SeriesRealmEntity(0, "", 0),
    var urls: RealmList<UrlRealmEntity> = RealmList()
) : RealmObject()

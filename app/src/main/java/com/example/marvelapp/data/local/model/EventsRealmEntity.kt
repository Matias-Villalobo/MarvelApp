package com.example.marvelapp.data.local.model

import io.realm.RealmObject

open class EventsRealmEntity(
    var available: Int = 0,
    var collectionURI: String = "",
    var returned: Int = 0
) : RealmObject()

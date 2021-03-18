package com.example.marvelapp.data.local.model

import com.example.marvelapp.data.local.model.utils.NumbersUtils.VALUE_ZERO
import com.example.marvelapp.data.local.model.utils.StringUtils.EMPTY_STRING
import io.realm.RealmObject

open class EventsRealmEntity(
    var available: Int = VALUE_ZERO,
    var collectionURI: String = EMPTY_STRING,
    var returned: Int = VALUE_ZERO
) : RealmObject()

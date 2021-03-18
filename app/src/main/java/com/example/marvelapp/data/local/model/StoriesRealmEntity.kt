package com.example.marvelapp.data.local.model

import com.example.marvelapp.data.local.model.utils.ConstantsUtils.VALUE_ZERO
import com.example.marvelapp.data.local.model.utils.ConstantsUtils.EMPTY_STRING
import io.realm.RealmObject

open class StoriesRealmEntity(
    var available: Int = VALUE_ZERO,
    var collectionURI: String = EMPTY_STRING,
    var returned: Int = VALUE_ZERO
) : RealmObject()

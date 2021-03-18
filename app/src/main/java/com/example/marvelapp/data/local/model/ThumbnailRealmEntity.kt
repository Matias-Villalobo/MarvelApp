package com.example.marvelapp.data.local.model

import com.example.marvelapp.data.local.model.utils.ConstantsUtils.EMPTY_STRING
import io.realm.RealmObject

open class ThumbnailRealmEntity(
    var path: String = EMPTY_STRING,
    var extension: String = EMPTY_STRING
) : RealmObject()

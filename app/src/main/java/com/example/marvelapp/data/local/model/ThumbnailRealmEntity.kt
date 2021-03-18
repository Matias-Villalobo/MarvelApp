package com.example.marvelapp.data.local.model

import com.example.marvelapp.data.local.model.utils.StringUtils.EMPTY_STRING
import io.realm.RealmObject

open class ThumbnailRealmEntity(
    var path: String = EMPTY_STRING,
    var extension: String = EMPTY_STRING
) : RealmObject()

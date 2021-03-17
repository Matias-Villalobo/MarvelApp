package com.example.marvelapp.data.local.model

import io.realm.RealmObject

open class ThumbnailRealmEntity(
    var path: String = "",
    var extension: String = ""
) : RealmObject()

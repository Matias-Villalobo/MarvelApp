package com.example.marvelapp.data.local.model

import com.example.marvelapp.data.local.model.utils.ConstantsUtils.EMPTY_STRING
import io.realm.RealmObject

open class UrlRealmEntity(
        var type: String = EMPTY_STRING,
        var url: String = EMPTY_STRING
) : RealmObject()


package com.example.marvelapp.data.local.model

import io.realm.RealmObject

open class UrlRealmEntity(
        var type: String = "",
        var url: String = ""
) : RealmObject()


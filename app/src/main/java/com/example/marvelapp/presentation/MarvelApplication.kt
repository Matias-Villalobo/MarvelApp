package com.example.marvelapp.presentation

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

class MarvelApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        var builder = RealmConfiguration.Builder()
        builder.allowWritesOnUiThread(true)
        Realm.setDefaultConfiguration(builder.build())
    }
}

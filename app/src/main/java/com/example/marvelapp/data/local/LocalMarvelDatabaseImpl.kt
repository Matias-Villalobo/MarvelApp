package com.example.marvelapp.data.local

import com.example.marvelapp.data.local.model.CharacterRealmEntity
import com.example.marvelapp.data.mapper.CharacterRealmMapper
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.local.LocalMarvelDataBase
import io.realm.Realm

class LocalMarvelDatabaseImpl(private val mapper: CharacterRealmMapper) : LocalMarvelDataBase {

    override fun saveCharacters(data: List<CharacterEntity>) {
        var realmInstance = Realm.getDefaultInstance()

        realmInstance.executeTransaction {
            realmInstance.deleteAll()
            var userRealm: List<CharacterRealmEntity> = mapper.transformDBListOfCharacters(data)
            realmInstance.insert(userRealm)
        }
    }
}

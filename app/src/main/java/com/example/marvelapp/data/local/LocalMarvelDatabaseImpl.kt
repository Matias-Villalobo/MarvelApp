package com.example.marvelapp.data.local

import com.example.marvelapp.data.local.model.CharacterRealmEntity
import com.example.marvelapp.data.mapper.CharacterRealmMapper
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.local.LocalMarvelDataBase
import io.realm.Realm

class LocalMarvelDatabaseImpl(private val mapper: CharacterRealmMapper) : LocalMarvelDataBase {

    override fun saveCharacters(characters: List<CharacterEntity>) {
        val realmInstance = Realm.getDefaultInstance()
        realmInstance.executeTransaction {
            realmInstance.deleteAll()
            val userRealm: List<CharacterRealmEntity> = mapper.transformEntityListToRealmList(characters)
            realmInstance.insert(userRealm)
        }
    }

    override fun loadCharacters(): List<CharacterEntity> {
        val realm = Realm.getDefaultInstance()
        val charactersRealm = realm.where(CharacterRealmEntity::class.java).findAll()
        return mapper.transformRealmListToEntityList(charactersRealm)
    }
}

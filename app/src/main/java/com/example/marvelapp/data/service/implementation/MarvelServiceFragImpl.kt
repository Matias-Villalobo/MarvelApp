package com.example.marvelapp.data.service.implementation

import com.example.marvelapp.data.mapper.CharacterMapper.transformSingleCharacter
import com.example.marvelapp.data.request.generator.MarvelRequestGenerator
import com.example.marvelapp.data.service.api.MarvelApi
import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.domain.service.MarvelServiceCharacterDetail
import io.reactivex.rxjava3.core.Observable

class MarvelServiceFragImpl : MarvelServiceCharacterDetail {

    private val api: MarvelRequestGenerator = MarvelRequestGenerator()

    override fun getSingleCharacter(id: Int): Observable<CharacterDetailEntity> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(MarvelApi::class.java).getSingleCharacter(id)
            val response = callResponse.execute()

            if (response.isSuccessful) {
                subscriber.onNext(response.body()?.data?.result?.let { transformSingleCharacter(it[0])})
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}

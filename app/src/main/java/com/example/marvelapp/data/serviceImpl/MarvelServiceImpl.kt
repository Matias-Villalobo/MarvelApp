package com.example.marvelapp.data.serviceImpl

import com.example.marvelapp.data.request.generator.MarvelRequestGenerator
import com.example.marvelapp.data.service.api.MarvelApi
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.data.mapper.CharacterMapper.transformListOfCharacters
import com.example.marvelapp.domain.contracts.MarvelService
import io.reactivex.rxjava3.core.Observable

class MarvelServiceImpl : MarvelService {

    private val api: MarvelRequestGenerator = MarvelRequestGenerator()
    override fun getCharacters(): Observable<List<CharacterEntity>> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(MarvelApi::class.java).getCharacter()
            val response = callResponse.execute()

            if (response.isSuccessful) {
                subscriber.onNext(response.body()?.data?.result?.let { transformListOfCharacters(it) })
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

}

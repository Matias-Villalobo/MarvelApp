package com.example.marvelapp.data.service.implementation

import com.example.marvelapp.data.mapper.CharacterMapper
import com.example.marvelapp.data.request.generator.MarvelRequestGenerator
import com.example.marvelapp.data.service.api.MarvelApi
import com.example.marvelapp.domain.entity.CharacterEntity
import com.example.marvelapp.data.mapper.CharacterMapper.transformListOfCharacters
import com.example.marvelapp.domain.entity.CharacterDetailEntity
import com.example.marvelapp.domain.service.MarvelService
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

    override fun getSingleCharacter(id: Int): Observable<CharacterDetailEntity> {
        return Observable.create { subscriber ->
            val callResponse = api.createService(MarvelApi::class.java).getSingleCharacter(id)
            val response = callResponse.execute()


            if (response.isSuccessful) {
                val validResponse = response.body()?.data?.result
                validResponse?.let {
                    if (it.isNotEmpty()) {
                        subscriber.onNext(CharacterMapper.transformSingleCharacter(it.first()))
                        subscriber.onComplete()
                    } else {
                        subscriber.onError(Throwable(ERROR_MESSAGE_EMPTY_RESPONSE))
                    }
                }
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

    companion object {
        private const val ERROR_MESSAGE_EMPTY_RESPONSE = "We can not get an answer because of an empty response"
    }

}

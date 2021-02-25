package com.example.marvelapp.data.request.generator

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MarvelRequestGenerator {

    private val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val defaultRequest = chain.request()
        val defaulthttpUrl = defaultRequest.url()
        val httpUrl = defaulthttpUrl.newBuilder()
                .addQueryParameter(PUBLIC_API_KEY_ARG, PUBLIC_API_KEY_VALUE)
                .addQueryParameter(PRIVATE_API_KEY_ARG, PRIVATE_API_HASH_VALUE)
                .addQueryParameter(TS, TS_VALUE)
                .build()
        val requestBuilder = defaultRequest.newBuilder().url(httpUrl)
        chain.proceed(requestBuilder.build())
    }
    private val builder = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S {
        val retrofit = builder.client(httpClient.build()).build()
        return retrofit.create(serviceClass)
    }

    companion object {
        private const val BASE_URL = "http://gateway.marvel.com/v1/public/"
        private const val PUBLIC_API_KEY_VALUE = "e6f692f1ab44e78947a2d66faf1dd97d"
        private const val PRIVATE_API_KEY_ARG = "hash"
        private const val PRIVATE_API_HASH_VALUE = "0ade61f277ba6a952fe85b3fc2b89322"
        private const val PUBLIC_API_KEY_ARG = "apikey"
        private const val TS = "ts"
        private const val TS_VALUE = "1"
    }
}

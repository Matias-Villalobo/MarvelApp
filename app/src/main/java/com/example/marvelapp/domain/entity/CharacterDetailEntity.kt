package com.example.marvelapp.domain.entity

class CharacterDetailEntity (
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: ThumbnailEntity,
    val events: EventsEntity,
    val comics: ComicsEntity,
    val stories: StoriesEntity,
    val series: SeriesEntity,
    val urls: List<UrlsEntity>,
    val resourceUri: String
    )

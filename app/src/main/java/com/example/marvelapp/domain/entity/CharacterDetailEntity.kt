package com.example.marvelapp.domain.entity

class CharacterDetailEntity(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: ThumbnailEntity,
    val resourceUri: String,
    val comics: ComicsEntity,
    val events: EventsEntity,
    val stories: StoriesEntity,
    val series: SeriesEntity,
    val urls: List<UrlEntity>
)

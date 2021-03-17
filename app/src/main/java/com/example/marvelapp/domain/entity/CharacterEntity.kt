package com.example.marvelapp.domain.entity

data class CharacterEntity(
        val id: Int,
        val name: String,
        val description: String,
        val modified: String,
        val thumbnail: ThumbnailEntity,
        val resourceUri: String,
        val events: EventsEntity,
        val comics: ComicsEntity,
        val stories: StoriesEntity,
        val series: SeriesEntity,
        val urls: List<UrlsEntity>
)

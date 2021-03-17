package com.example.marvelapp.data.service.response

open class CharacterEntity(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: ThumbnailResponse,
    val resourceUri: String,
    val comics: ComicsResponse,
    val urls: List<UrlResponse>,
    val series: SeriesResponse,
    val stories: StoriesResponse,
    val events: EventsResponse
)

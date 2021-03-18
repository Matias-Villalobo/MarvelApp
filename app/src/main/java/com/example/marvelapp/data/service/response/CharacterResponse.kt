package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class CharacterResponse(
   @SerializedName("id") val id: Int,
   @SerializedName("name") val name: String,
   @SerializedName("description") val description: String,
   @SerializedName("modified") val modified: String,
   @SerializedName("thumbnail") val thumbnail: ThumbnailResponse,
   @SerializedName("resourceURI") val resourceUri: String,
   @SerializedName("comics") val comics: ComicsResponse,
   @SerializedName("urls") val urls: List<UrlResponse>,
   @SerializedName("series") val series: SeriesResponse,
   @SerializedName("stories") val stories: StoriesResponse,
   @SerializedName("events") val events: EventsResponse
)

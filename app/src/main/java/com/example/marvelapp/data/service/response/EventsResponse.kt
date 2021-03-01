package com.example.marvelapp.data.service.response

import com.google.gson.annotations.SerializedName

class EventsResponse(
    @SerializedName("available") val available: Int
)

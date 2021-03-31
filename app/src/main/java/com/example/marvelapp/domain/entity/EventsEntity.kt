package com.example.marvelapp.domain.entity

import com.example.marvelapp.domain.entity.utils.ConstantsUtils.EMPTY_STRING
import com.example.marvelapp.domain.entity.utils.ConstantsUtils.VALUE_ZERO

data class EventsEntity(
    val available: Int = VALUE_ZERO,
    val collectionURI: String = EMPTY_STRING,
    val returned: Int = VALUE_ZERO
)

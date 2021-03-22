package com.example.marvelapp.domain.entity

import com.example.marvelapp.data.local.model.utils.ConstantsUtils.EMPTY_STRING
import com.example.marvelapp.data.local.model.utils.ConstantsUtils.VALUE_ZERO

class StoriesEntity(
    val available: Int = VALUE_ZERO,
    val collectionURI: String = EMPTY_STRING,
    val returned: Int = VALUE_ZERO
)

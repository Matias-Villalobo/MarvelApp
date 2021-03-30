package com.example.marvelapp.domain.entity

import com.example.marvelapp.domain.entity.utils.ConstantsUtils.EMPTY_STRING

data class ThumbnailEntity(
    val path: String = EMPTY_STRING,
    val extension: String = EMPTY_STRING
)

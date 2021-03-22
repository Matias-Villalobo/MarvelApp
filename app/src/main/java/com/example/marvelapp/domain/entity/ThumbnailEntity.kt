package com.example.marvelapp.domain.entity

import com.example.marvelapp.data.local.model.utils.ConstantsUtils.EMPTY_STRING

class ThumbnailEntity(
    val path: String = EMPTY_STRING,
    val extension: String = EMPTY_STRING
)

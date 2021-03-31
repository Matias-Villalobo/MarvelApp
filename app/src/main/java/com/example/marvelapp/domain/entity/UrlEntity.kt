package com.example.marvelapp.domain.entity

import com.example.marvelapp.domain.entity.utils.ConstantsUtils.EMPTY_STRING

data class UrlEntity(
    var type: String = EMPTY_STRING,
    var url: String = EMPTY_STRING
)

package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class ImageLinks(
    @SerialName("smallThumbnail") val smallThumbnail: String?,
    @SerialName("thumbnail") val thumbnail: String?
)
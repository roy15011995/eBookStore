package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName

/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class BookResponse(
    @SerialName("kind") val kind: String?,
    @SerialName("totalItems") val totalItems: Int?,
    @SerialName("items") val items: List<BookItems>?
)

package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class SearchInfo(
    @SerialName("textSnippet") val textSnippet: String?
)
package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName


/**
 * CCreated by Amit Roy on Date : 26/11/25
 */
data class IndustryIdentifiers(
    @SerialName("type") val type: String?,
    @SerialName("identifier") val identifier: String?
)
package com.aroy.ebookstore.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class ReadingModes(
    @SerialName("text") val text: Boolean?,
    @SerialName("image") val image: Boolean?
)
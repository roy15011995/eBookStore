package com.aroy.ebookstore.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class AccessInfo(
    @SerialName("country") val country: String?,
    @SerialName("viewability") val viewability: String?,
    @SerialName("embeddable") val embeddable: Boolean?,
    @SerialName("publicDomain") val publicDomain: Boolean?,
    @SerialName("textToSpeechPermission") val textToSpeechPermission: String?,
    @SerialName("epub") val epub: Epub?,
    @SerialName("pdf") val pdf: Pdf?,
    @SerialName("webReaderLink") val webReaderLink: String?,
    @SerialName("accessViewStatus") val accessViewStatus: String?,
    @SerialName("quoteSharingAllowed") val quoteSharingAllowed: Boolean?
)
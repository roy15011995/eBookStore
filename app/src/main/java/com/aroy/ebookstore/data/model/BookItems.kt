package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class BookItems(
    @SerialName("kind") val kind: String?,
    @SerialName("id") val id: String?,
    @SerialName("etag") val etag: String?,
    @SerialName("selfLink") val selfLink: String?,
    @SerialName("volumeInfo") val volumeInfo: VolumeInfo?,
    @SerialName("saleInfo") val saleInfo: SaleInfo?,
    @SerialName("accessInfo") val accessInfo: AccessInfo?,
    @SerialName("searchInfo") val searchInfo: SearchInfo?
)

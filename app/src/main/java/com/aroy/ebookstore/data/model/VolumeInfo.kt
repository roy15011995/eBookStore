package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class VolumeInfo(
    @SerialName("title") val title: String?,
    @SerialName("subtitle") val subtitle: String?,
    @SerialName("authors") val authors: List<String>?,
    @SerialName("publisher") val publisher: String?,
    @SerialName("publishedDate") val publishedDate: String?,
    @SerialName("description") val description: String?,
    @SerialName("industryIdentifiers") val industryIdentifiers: List<IndustryIdentifiers>?,
    @SerialName("readingModes") val readingModes: ReadingModes?,
    @SerialName("pageCount") val pageCount: Int?,
    @SerialName("printType") val printType: String?,
    @SerialName("categories") val categories: List<String>?,
    @SerialName("averageRating") val averageRating: Double?,
    @SerialName("ratingsCount") val ratingsCount: Int?,
    @SerialName("maturityRating") val maturityRating: String?,
    @SerialName("allowAnonLogging") val allowAnonLogging: Boolean?,
    @SerialName("contentVersion") val contentVersion: String?,
    @SerialName("panelizationSummary") val panelizationSummary: PanelizationSummary?,
    @SerialName("imageLinks") val imageLinks: ImageLinks?,
    @SerialName("language") val language: String?,
    @SerialName("previewLink") val previewLink: String?,
    @SerialName("infoLink") val infoLink: String?,
    @SerialName("canonicalVolumeLink") val canonicalVolumeLink: String?
)
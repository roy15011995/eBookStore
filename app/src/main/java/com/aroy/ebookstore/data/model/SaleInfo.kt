package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class SaleInfo(
    @SerialName("country") val country: String?,
    @SerialName("saleability") val saleability: String?,
    @SerialName("isEbook") val isEbook: Boolean?
)
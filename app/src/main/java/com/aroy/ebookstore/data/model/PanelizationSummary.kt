package com.example.composebookstoreapplication.model

import kotlinx.serialization.SerialName


/**
 * Created by Amit Roy on Date : 26/11/25
 */
data class PanelizationSummary(
    @SerialName("containsEpubBubbles") val containsEpubBubbles: Boolean?,
    @SerialName("containsImageBubbles") val containsImageBubbles: Boolean?
)
package com.aroy.ebookstore.core.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * Created by Amit Roy on Date : 28/11/25
 */
@Composable
fun RatingBar(
    maxRating: Int = 5,
    currentRating: Int,
    starsColor: Color = MaterialTheme.colorScheme.secondary
) {
    Row {
        for (i in 1..maxRating) {
            Icon(
                imageVector = if (i <= currentRating) Icons.Filled.Star
                else Icons.Outlined.Star,
                contentDescription = null,
                tint = if (i <= currentRating) starsColor
                else MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
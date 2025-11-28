package com.aroy.ebookstore.core.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberImagePainter
import coil.request.CachePolicy
import coil.request.ImageRequest

/**
 * Created by Amit Roy on Date : 28/11/25
 */
@Composable
fun ImageView(
    imageUrl: String,
    title: String,
    height: Int,
    width: Int,
    drawableImage: Int
) {
    val context = LocalContext.current
    val imageRequest = ImageRequest.Builder(context)
        .data(imageUrl.replace("http", "https"))
        .memoryCacheKey(imageUrl.replace("http", "https"))
        .placeholder(drawableImage)
        .error(drawableImage)
        .fallback(drawableImage)
        .diskCachePolicy(CachePolicy.ENABLED)
        .memoryCachePolicy(CachePolicy.ENABLED)
        .size(width, height)
        .build()

    Image(
        painter = rememberImagePainter(
            request = imageRequest
        ),
        contentDescription = title
    )
}
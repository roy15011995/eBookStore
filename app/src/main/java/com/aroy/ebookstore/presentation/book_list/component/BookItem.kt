package com.aroy.ebookstore.presentation.book_list.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aroy.ebookstore.R
import com.aroy.ebookstore.core.components.ImageView
import com.aroy.ebookstore.core.components.RatingBar
import com.aroy.ebookstore.model.BookItems
import kotlin.text.orEmpty

/**
 * Created by Amit Roy on Date : 28/11/25
 */

@Composable
fun BookItem(
    booksItems: BookItems?,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        Column {
            Spacer(modifier = Modifier.width(10.dp))
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                ImageView(
                    imageUrl = booksItems?.volumeInfo?.imageLinks?.smallThumbnail.orEmpty(),
                    title = booksItems?.volumeInfo?.title.orEmpty(),
                    height = 300,
                    width = 200,
                    drawableImage = R.drawable.gallery
                )

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = booksItems?.volumeInfo?.title ?: "Title not available",
                        maxLines = 1,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = booksItems?.volumeInfo?.subtitle ?: "Subtitle not available",
                        maxLines = 1,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 16.sp,
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    Text(
                        text = booksItems?.volumeInfo?.authors?.getOrNull(0)
                            ?: "Author not available",
                        maxLines = 1,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                    )

                    Spacer(modifier = Modifier.height(3.dp))

                    RatingBar(currentRating = booksItems?.volumeInfo?.averageRating?.toInt() ?: 2)
                }
            }

            Spacer(modifier = Modifier.height(5.dp))

            Divider(modifier = Modifier.height(1.dp))

            Spacer(modifier = Modifier.height(8.dp))

        }
    }
}
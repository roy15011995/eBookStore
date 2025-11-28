package com.aroy.ebookstore.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.SerialName

/**
 * Created by Amit Roy on Date : 26/11/25
 */
@Entity(tableName = "book_response")
data class BookResponse(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerialName("items") val items: List<BookItems>?
)

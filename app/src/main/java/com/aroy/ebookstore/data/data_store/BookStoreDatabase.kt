package com.aroy.ebookstore.data.data_store

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aroy.ebookstore.data.Converters
import com.example.composebookstoreapplication.model.BookResponse

/**
 * Created by Amit Roy on Date : 26/11/25
 */

@Database(
    entities = [BookResponse::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class BookStoreDatabase: RoomDatabase() {
}
package com.aroy.ebookstore.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aroy.ebookstore.core.Converters
import com.aroy.ebookstore.data.dao.BookResponseDao
import com.aroy.ebookstore.model.BookResponse

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
    abstract fun bookResponseDao(): BookResponseDao
}
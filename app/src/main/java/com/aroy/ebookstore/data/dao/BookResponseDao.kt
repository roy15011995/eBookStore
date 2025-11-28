package com.aroy.ebookstore.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aroy.ebookstore.model.BookResponse

/**
 * Created by Amit Roy on Date : 27/11/25
 */
@Dao
interface BookResponseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertResponse(bookResponse: BookResponse)

    @Query("SELECT * FROM book_response ORDER BY id DESC LIMIT 1")
    suspend fun getLatestResponse(): BookResponse?
}
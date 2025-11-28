package com.aroy.ebookstore.core.di

import android.content.Context
import androidx.room.Room
import com.aroy.ebookstore.data.database.BookStoreDatabase
import com.aroy.ebookstore.core.network.service.BooksAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson
import javax.inject.Singleton

/**
 * Created by Amit Roy on Date : 27/11/25
 */
@Module
@InstallIn(SingletonComponent::class)
object EBookStoreAppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient = HttpClient(OkHttp) {
        install(ContentNegotiation) {
            gson()
        }
    }

    @Provides
    @Singleton
    fun provideBookAPI(client: HttpClient): BooksAPI = BooksAPI(client)

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): BookStoreDatabase =
        Room.databaseBuilder(context, BookStoreDatabase::class.java, "book_store_db").build()

    @Provides
    @Singleton
    fun provideBookResponseDao(database: BookStoreDatabase) = database.bookResponseDao()
}
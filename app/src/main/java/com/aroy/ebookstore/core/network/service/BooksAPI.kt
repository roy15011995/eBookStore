package com.aroy.ebookstore.core.network.service

import com.aroy.ebookstore.core.network.APIConfig
import com.aroy.ebookstore.model.BookResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

/**
* Created by Amit Roy on Date : 26/11/25
*/
class BooksAPI(private val client: HttpClient) {
    suspend fun searchBooks(
        query: String,
        author: String? = null,
        page: Int? = null,
        limit: Int? = null
    ): BookResponse {
        return client.get("${APIConfig.BASE_URL}/books/v1/volumes") {
            parameter("q", query)
            author?.let { parameter("inauthor", it) }
            page?.let { parameter("startIndex", it) }
            limit?.let { parameter("maxResults", it) }
        }.body()
    }
}
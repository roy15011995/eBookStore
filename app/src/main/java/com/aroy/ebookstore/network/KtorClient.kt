package com.aroy.ebookstore.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

/**
 * Created by Amit Roy on Date : 26/11/25
 */
object KtorClient {
    val client: HttpClient = HttpClient {
        install(ContentNegotiation) {
            gson()
        }
    }
}
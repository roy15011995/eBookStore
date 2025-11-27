package com.aroy.ebookstore.data.data_store

/**
 * Created by Amit Roy on Date : 26/11/25
 *
 * [ResourceDataProvider]
 *
 * A generic utility function that implements an offline‑first data access strategy.
 * It attempts to load data from a local cache first, and only falls back to fetching
 * from a remote source if the cache is empty or if a forced refresh is requested.
 * After fetching from the remote source, the result is saved back into the cache.
 *
 * This pattern is commonly used in repositories to unify cache and network logic,
 * ensuring that the UI can display cached data quickly while still keeping data fresh.
 *
 * @param loadCache A suspend function that loads data from the local cache (e.g. Room, SharedPrefs).
 *                  Returns the cached data or null if not available.
 * @param fetchRemote A suspend function that fetches fresh data from a remote source (e.g. Ktor API call).
 * @param saveRemoteData A suspend function that saves the fetched remote data into the local cache.
 * @param forceRefresh If true, bypasses the cache and always fetches from the remote source.
 *
 * @return The data of type [T], either loaded from cache or freshly fetched from the remote source.
 *
 * Example usage:
 * ```
 * suspend fun getBooks(query: String, forceRefresh: Boolean = false): BookResponse {
 *     return ResourceDataProvider(
 *         loadCache = { dao.getLatestResponse()?.toDomainModel() },
 *         fetchRemote = { api.searchBooks(query) },
 *         saveRemoteData = { dao.insertResponse(it.toEntity()) },
 *         forceRefresh = forceRefresh
 *     )
 * }
 * ```
 */
suspend fun <T> ResourceDataProvider(
    loadCache: suspend () -> T?,
    fetchRemote: suspend () -> T,
    saveRemoteData: suspend (T) -> Unit,
    forceRefresh: Boolean = false
): T {
    val cached = if (!forceRefresh) loadCache() else null
    return cached ?: fetchRemote().also { saveRemoteData(it) }
}
package com.aroy.ebookstore.presentation.book_list.viewModel

sealed class BookListIntent {
    data class LoadBooks(val query: String, val author: String? = null) : BookListIntent()
    data class SelectBook(val bookId: String?) : BookListIntent()
    data object OpenFavoriteBooks : BookListIntent()
}
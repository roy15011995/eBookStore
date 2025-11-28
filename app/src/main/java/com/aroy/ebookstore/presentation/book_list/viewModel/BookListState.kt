package com.aroy.ebookstore.presentation.book_list.viewModel

import com.aroy.ebookstore.model.BookItems


data class BookListState(
    val isLoading: Boolean = false,
    val books: List<BookItems> = emptyList(),
    val error: String? = null
)
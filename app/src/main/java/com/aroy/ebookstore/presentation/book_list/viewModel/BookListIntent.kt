package com.aroy.ebookstore.presentation.book_list.viewModel

sealed class BookListIntent {
    object LoadBooks : BookListIntent()
    data class SelectBook(val bookId: String?) : BookListIntent()
}
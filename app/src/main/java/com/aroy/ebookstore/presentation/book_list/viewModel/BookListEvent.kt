package com.aroy.ebookstore.presentation.book_list.viewModel

sealed class BookListEvent {
    data class NavigateToDetails(val bookId: String?) : BookListEvent()
    data class ShowToast(val message: String?) : BookListEvent()
    data object NavigateToFavorite : BookListEvent()
}
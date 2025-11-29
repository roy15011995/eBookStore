package com.example.composebookstoreapplication.core.navigation

/**
 * Created by amitroy on Date : 18/11/23
 */
sealed class Screen(val route: String) {
    data object BookListScreen: Screen("book_list_screen")
    data object BookDetailsScreen: Screen("book_details_screen")
    data object FavoriteBooksScreen: Screen("favorite_books_screen")
}
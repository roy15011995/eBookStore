package com.aroy.ebookstore.presentation.book_list.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aroy.ebookstore.core.components.CustomTopAppBar
import com.aroy.ebookstore.presentation.book_list.component.BookItem
import com.aroy.ebookstore.presentation.book_list.viewModel.BookListEvent
import com.aroy.ebookstore.presentation.book_list.viewModel.BookListIntent
import com.aroy.ebookstore.presentation.book_list.viewModel.BookListViewModel
import com.example.composebookstoreapplication.core.navigation.Screen

/**
 * Created by Amit Roy on Date : 27/11/25
 */
@Composable
fun BookListScreen(
    navController: NavController,
    viewModel: BookListViewModel
) {
    val state by viewModel.viewState.collectAsState()
    val events = viewModel.events.collectAsState(initial = null)

    // Trigger LoadBooks intent automatically when the screen is first composed
    LaunchedEffect(Unit) {
        viewModel.processIntent(BookListIntent.LoadBooks)
    }

    // Handle one-time events
    LaunchedEffect(events.value) {
        events.value?.let { event ->
            when (event) {
                is BookListEvent.NavigateToDetails -> {
                    navController.navigate(Screen.BookDetailsScreen.route)
                }

                is BookListEvent.ShowToast -> {
                    // Show toast message
                }
            }
        }
    }

    Scaffold(
        topBar = { CustomTopAppBar(navController = navController, text = "Book List") }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                state.isLoading -> CircularProgressIndicator()
                state.error != null -> Text("Error : ${state.error}")
                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(15.dp)
                    ) {
                        items(state.books) { bookItem ->
                            BookItem(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        navController.currentBackStackEntry?.savedStateHandle?.set(
                                            key = "book",
                                            value = bookItem
                                        )
                                        viewModel.processIntent(
                                            BookListIntent.SelectBook(bookItem.id)
                                        )
                                    },
                                booksItems = bookItem
                            )
                        }
                    }
                }
            }
        }
    }
}
package com.aroy.ebookstore.core.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

/**
 * Created by Amit Roy on Date : 28/11/25
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(
    navController: NavController,
    text: String,
    screenType: ScreenType = ScreenType.OTHER,
    action: (ClickType) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
        actions = {
            IconButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.White
                )
            }
            if(screenType == ScreenType.HOME) {
                IconButton(
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Favorite",
                        tint = Color.White
                    )
                }
            }
            IconButton(
                onClick = { expanded = true }
            ) {
                Icon(imageVector = Icons.Default.MoreVert,
                    contentDescription = "More",
                    tint = Color.White
                )
            }
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                DropdownMenuItem(
                    text = { Text("Settings") },
                    onClick = { }
                )
                DropdownMenuItem(
                    text = { Text("Help") },
                    onClick = { }
                )
            }
        },
        navigationIcon = {
            if (navController.previousBackStackEntry != null) {
                run {
                    IconButton(
                        onClick = { action.invoke(ClickType.BACK) }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Back",
                            tint = Color.White
                        )
                    }
                }
            } else {
                IconButton(
                    onClick = { action.invoke(ClickType.DRAWER) }) {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Hamburger Menu",
                        tint = Color.White
                    )
                }
            }
        },
        title = {
            Text(
                text = text,
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace,
                color = Color.White
            )
        }
    )
}

enum class ClickType {
    BACK,
    DRAWER
}

enum class ScreenType {
    HOME,
    OTHER
}
package com.aroy.ebookstore.core.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
    action: (ClickType) -> Unit
){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
        ),
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
                fontFamily = FontFamily.Monospace
            )
        }
    )
}
enum class ClickType{
    BACK,
    DRAWER
}
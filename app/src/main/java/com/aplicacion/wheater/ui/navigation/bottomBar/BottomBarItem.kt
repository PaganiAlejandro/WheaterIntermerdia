package com.aplicacion.wheater.ui.navigation.bottomBar

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.aplicacion.wheater.R

enum class BottomBarItem(
    val icon: ImageVector,
    @StringRes val title: Int,
    val option: String
) {
    CURRENT(Icons.Default.LocationOn, R.string.bottom_bar_current, "current"),
    SEARCH(Icons.Default.Search, R.string.bottom_bar_search, "search"),
    FAVORITE(Icons.Default.List, R.string.bottom_bar_favorite, "favorite")
}
package com.aplicacion.wheater.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.aplicacion.wheater.R

enum class NavItem(
    val navCommand: NavCommand,
    val icon: ImageVector,
    @StringRes val title: Int
) {
    CURRENT(NavCommand.ContentType(Feature.CURRENT), Icons.Default.LocationOn, R.string.bottom_bar_current),
    SEARCH(NavCommand.ContentType(Feature.SEARCH), Icons.Default.Search, R.string.bottom_bar_search),
    FAVORITE(NavCommand.ContentType(Feature.FAVORITE), Icons.Default.List, R.string.bottom_bar_favorite),
}

sealed class NavCommand(
    internal val feature: Feature,
    internal val subRoute: String = "current",
    private val navArgs: List<NavArg> = emptyList()
) {
    class ContentType(feature: Feature) : NavCommand(feature)

    class ContentTypeDetail(feature: Feature) :
        NavCommand(feature, "detail", listOf(NavArg.ItemId)) {
        fun createRoute(itemId: Int) = "${feature.route}/$subRoute/$itemId"
    }

    val route = run {
        val argValues = navArgs.map { "{${it.key}}" }
        listOf(feature.route)
            .plus(subRoute)
            .plus(argValues)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }

}

enum class NavArg(val key: String, val navType: NavType<*>) {
    ItemId("itemId", NavType.IntType)
}
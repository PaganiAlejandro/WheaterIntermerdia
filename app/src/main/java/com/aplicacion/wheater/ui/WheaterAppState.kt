package com.aplicacion.wheater.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aplicacion.wheater.ui.navigation.NavItem
import com.aplicacion.wheater.ui.navigation.navigatePoppingUpToStartDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberWheaterAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) : WheaterAppState = remember(scaffoldState, navController, coroutineScope) {
    WheaterAppState(scaffoldState, navController, coroutineScope)
}

class WheaterAppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val coroutineScope: CoroutineScope
) {

    companion object {
        val BOTTOM_NAV_OPTIONS = listOf(NavItem.SEARCH, NavItem.CURRENT, NavItem.FAVORITE)
    }

    val currentRoute: String @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    val showUpNavigation: Boolean @Composable get() = !NavItem.values().map { it.navCommand.route }.contains(currentRoute)

    val showBottomNavigation: Boolean
        @Composable get() = BOTTOM_NAV_OPTIONS.any { currentRoute.contains(it.navCommand.feature.route) }

    fun onUpClick() {
        navController.popBackStack()
    }

    fun onNavItemClick(navItem: NavItem) {
        navController.navigatePoppingUpToStartDestination(navItem.navCommand.route)
    }
}
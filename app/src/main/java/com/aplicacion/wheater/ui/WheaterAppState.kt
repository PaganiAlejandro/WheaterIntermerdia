package com.aplicacion.wheater.ui

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aplicacion.wheater.ui.navigation.bottomBar.BottomBarItem
import com.aplicacion.wheater.ui.navigation.bottomBar.Screen
import com.aplicacion.wheater.ui.navigation.bottomBar.navigatePoppingUpToStartDestination
import com.aplicacion.wheater.ui.navigation.bottomBar.navigateToMain
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberWheaterAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) : WheaterAppState = remember("current",scaffoldState, navController, coroutineScope) {
    WheaterAppState("current", scaffoldState, navController, coroutineScope)
}

class WheaterAppState(
    val bottonBarSelected: String,
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val coroutineScope: CoroutineScope
) {

    companion object {
        val BOTTOM_NAV_OPTIONS = listOf(BottomBarItem.SEARCH, BottomBarItem.CURRENT, BottomBarItem.FAVORITE)
    }

    val currentOptionSelected : String @Composable get() = bottonBarSelected

    val currentRoute: String @Composable get() = navController.currentBackStackEntryAsState().value?.destination?.route ?: ""

    // val showUpNavigation: Boolean @Composable get() = !BottomBarItem.values().map { it.route }.contains(currentRoute)
    //
    // val showBottomNavigation: Boolean
    //     @Composable get() = BOTTOM_NAV_OPTIONS.any { currentRoute.contains(it.route) }

    fun onUpClick() {
        navController.popBackStack()
    }

    // fun onNavItemClick(bottomBarItem: BottomBarItem) {
    //     navController.navigatePoppingUpToStartDestination(bottomBarItem.route)
    // }

}
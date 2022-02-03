package com.aplicacion.wheater.ui.navigation.bottomBar

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aplicacion.wheater.ui.WheaterAppState
import com.aplicacion.wheater.ui.screen.main.WheaterMainScreen
import com.aplicacion.wheater.ui.splashScreen

@ExperimentalMaterialApi
@Composable
fun SetupNavGraph(appState: WheaterAppState) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = Screen.SPLASH.route
    ) {
        splashNav(navController)
        mainNav(appState)
        // searchNav(navController)
        // currentNav(navController)
        // favoriteNav(navController)
    }
}

private fun NavGraphBuilder.splashNav(navController: NavController) {
    composable(route = Screen.SPLASH.route) {
        splashScreen(
            toMain = {
                navController.navigate(Screen.MAIN.route) {
                    popUpTo(Screen.SPLASH.route) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

@ExperimentalMaterialApi
private fun NavGraphBuilder.mainNav(appState: WheaterAppState) {
    composable(route = Screen.MAIN.route) {
        WheaterMainScreen(appState)
    }
}

// private fun NavGraphBuilder.searchNav(navController: NavController) {
//     composable(route = Screen.SEARCH.route) {
//         SearchScreen(
//
//         )
//     }
// }
//
// private fun NavGraphBuilder.currentNav(navController: NavController) {
//     composable(route = Screen.CURRENT.route) {
//         CurrentCityScreen(
//
//         )
//     }
// }
//
// private fun NavGraphBuilder.favoriteNav(navController: NavController) {
//     composable(route = Screen.FAVORITE.route) {
//         FavoriteScreen(
//
//         )
//     }
// }
package com.aplicacion.wheater.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aplicacion.wheater.ui.screen.currentCity.CurrentCityScreen
import com.aplicacion.wheater.ui.screen.favorite.FavoriteScreen
import com.aplicacion.wheater.ui.screen.search.SearchScreen

@ExperimentalMaterialApi
@ExperimentalFoundationApi
@Composable
fun Navigation(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Feature.CURRENT.route
    ) {
        searchNav(navController)
        currentNav(navController)
        favoriteNav(navController)
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.searchNav(navController: NavController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.SEARCH).route,
        route = Feature.SEARCH.route
    ) {
        composable(NavCommand.ContentType(Feature.SEARCH)) {
            SearchScreen(
                // onClick = { character ->
                //     navController.navigate(
                //         NavCommand.ContentTypeDetail(Feature.SEARCH).createRoute(character.id)
                //     )
                // }
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.currentNav(navController: NavController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.CURRENT).route,
        route = Feature.CURRENT.route
    ) {
        composable(NavCommand.ContentType(Feature.CURRENT)) {
            CurrentCityScreen(
                // onClick = { city ->
                //     navController.navigate(
                //         NavCommand.ContentTypeDetail(Feature.CURRENT).createRoute(city.id)
                //     )
                // }
            )
        }
    }
}

@ExperimentalMaterialApi
@ExperimentalFoundationApi
private fun NavGraphBuilder.favoriteNav(navController: NavController) {
    navigation(
        startDestination = NavCommand.ContentType(Feature.FAVORITE).route,
        route = Feature.FAVORITE.route
    ) {
        composable(NavCommand.ContentType(Feature.FAVORITE)) {
            FavoriteScreen(
                // onClick = { favorite ->
                //     navController.navigate(
                //         NavCommand.ContentTypeDetail(Feature.FAVORITE).createRoute(favorite.id)
                //     )
                // }
            )
        }
    }
}

private fun NavGraphBuilder.composable(
    navCommand: NavCommand,
    content: @Composable (NavBackStackEntry) -> Unit
) {
    composable(
        route = navCommand.route,
        arguments = navCommand.args
    ) {
        content(it)
    }
}
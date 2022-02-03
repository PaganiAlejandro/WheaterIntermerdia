package com.aplicacion.wheater.ui.screen.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.aplicacion.wheater.ui.WheaterAppState
import com.aplicacion.wheater.ui.navigation.bottomBar.AppBottomNavigation
import com.aplicacion.wheater.ui.navigation.bottomBar.BottomBarItem
import com.aplicacion.wheater.ui.screen.CurrentCityScreen
import com.aplicacion.wheater.ui.screen.FavoriteScreen
import com.aplicacion.wheater.ui.screen.search.SearchScreen

@OptIn(ExperimentalFoundationApi::class)
@ExperimentalMaterialApi
@Composable
fun WheaterMainScreen(appState: WheaterAppState) {
    var optionSelecte by remember { mutableStateOf(BottomBarItem.CURRENT.option) }
    Scaffold(
        bottomBar = {
            AppBottomNavigation(
                bottomBottomBarOptions = WheaterAppState.BOTTOM_NAV_OPTIONS,
                currentOption = optionSelecte,
                onNavItemClick = { optionSelecte = it.option })
        },
        scaffoldState = appState.scaffoldState
    )
    { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when (optionSelecte) {
                BottomBarItem.CURRENT.option -> CurrentCityScreen()
                BottomBarItem.SEARCH.option -> SearchScreen()
                BottomBarItem.FAVORITE.option -> FavoriteScreen()
            }
        }
    }
}
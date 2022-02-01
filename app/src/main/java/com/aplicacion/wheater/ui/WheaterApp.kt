package com.aplicacion.wheater.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aplicacion.wheater.ui.navigation.AppBottomNavigation
import com.aplicacion.wheater.ui.navigation.Navigation
import com.aplicacion.wheater.ui.theme.WheaterTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun WheaterApp(appState: WheaterAppState = rememberWheaterAppState()) {

    WheaterScreen {
        Scaffold(
            bottomBar = {
                AppBottomNavigation(
                    bottomNavOptions = WheaterAppState.BOTTOM_NAV_OPTIONS,
                    currentRoute = appState.currentRoute,
                    onNavItemClick = { appState.onNavItemClick(it) })
            },
            scaffoldState = appState.scaffoldState
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                Navigation(appState.navController)
            }
        }
    }
}

@Composable
fun WheaterScreen(content: @Composable () -> Unit) {
    WheaterTheme() {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}
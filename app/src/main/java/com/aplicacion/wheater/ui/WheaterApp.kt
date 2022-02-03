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
import com.aplicacion.wheater.ui.navigation.bottomBar.AppBottomNavigation
import com.aplicacion.wheater.ui.navigation.bottomBar.Screen
import com.aplicacion.wheater.ui.navigation.bottomBar.SetupNavGraph
import com.aplicacion.wheater.ui.theme.WheaterTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Composable
fun WheaterApp(appState: WheaterAppState = rememberWheaterAppState()) {
    WheaterTheme {
        Surface(color = MaterialTheme.colors.background) {
            SetupNavGraph(appState)
        }
    }
}
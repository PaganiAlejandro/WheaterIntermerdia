package com.aplicacion.wheater.ui.navigation.bottomBar

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

fun NavHostController.navigatePoppingUpToStartDestination(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.navigateToMain(route: String) {
    navigate(route) {
        popUpTo(graph.findStartDestination().id) {
            inclusive = true
        }
    }
}
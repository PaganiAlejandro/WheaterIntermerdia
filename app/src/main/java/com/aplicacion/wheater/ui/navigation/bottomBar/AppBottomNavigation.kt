package com.aplicacion.wheater.ui.navigation.bottomBar

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

@Composable
fun AppBottomNavigation(
    bottomBottomBarOptions: List<BottomBarItem>,
    currentOption: String,
    onNavItemClick: (BottomBarItem) -> Unit
) {
    WheaterBottomNavigation {
        bottomBottomBarOptions.forEach { item ->
            val title = stringResource(item.title)
            BottomNavigationItem(
                selected = currentOption.contains(item.option),
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = title
                    )
                },
                label = { Text(text = title) },
                onClick = { onNavItemClick(item) }
            )
        }
    }
}
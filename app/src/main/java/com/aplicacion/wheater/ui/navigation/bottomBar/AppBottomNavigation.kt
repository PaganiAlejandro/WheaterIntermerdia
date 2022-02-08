package com.aplicacion.wheater.ui.navigation.bottomBar

import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.aplicacion.wheater.ui.theme.selectItem
import com.aplicacion.wheater.ui.theme.textColor_probability

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
                        contentDescription = title,
                        tint = getTintColor(currentOption.contains(item.option))
                    )
                },
                label = { Text(text = title) },
                onClick = { onNavItemClick(item) }
            )
        }
    }
}

private fun getTintColor(value: Boolean): Color {
    if (value){
        return selectItem
    } else {
        return textColor_probability
    }
}
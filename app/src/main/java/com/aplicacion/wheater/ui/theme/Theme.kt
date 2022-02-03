package com.aplicacion.wheater.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = Bg_splash_dark,
    primaryVariant = Bg_splash_dark,
    secondary = Bg_splash_dark,
    background = Bg_splash
)

@SuppressLint("ConflictingOnColor")
private val LightColorPalette = lightColors(
    primary = Bg_splash,
    primaryVariant = Bg_splash,
    secondary = Bg_splash,
    background = Bg_splash
)

@Composable
fun WheaterTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
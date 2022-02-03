package com.aplicacion.wheater.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FavoriteScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Favorite", style = MaterialTheme.typography.h3, modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.Center))
    }
}
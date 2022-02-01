package com.aplicacion.wheater.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aplicacion.wheater.R

@Composable
fun splashScreen() {
    Surface(color = MaterialTheme.colors.background) {
        Box(modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(), contentAlignment = Alignment.Center) {
            Column() {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = MaterialTheme.colors.onPrimary,
                    modifier = Modifier
                        .width(100.dp)
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally),
                    style = MaterialTheme.typography.h5,
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "splash",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewSplash() {
    splashScreen()
}
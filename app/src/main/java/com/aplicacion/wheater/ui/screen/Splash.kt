package com.aplicacion.wheater.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aplicacion.wheater.R
import com.aplicacion.wheater.ui.splash
import kotlinx.coroutines.delay

@Composable
fun splashScreen(toMain: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 3000
        )
    )

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(3000)
        toMain.invoke()
    }
    splash(alpha = alphaAnim.value)
}

@Composable
fun splash(alpha: Float) {
    Surface(color = MaterialTheme.colors.background) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(), contentAlignment = Alignment.Center
        ) {
            Column {
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
                        .alpha(alpha = alpha)
                )
            }
        }
    }
}
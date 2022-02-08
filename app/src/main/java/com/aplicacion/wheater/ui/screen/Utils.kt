package com.aplicacion.wheater.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aplicacion.wheater.R
import com.aplicacion.wheater.data.entities.WHEATER

val paddingStart = 24.dp
val paddingEnd = 24.dp

val textStyleH1 = TextStyle(color = Color.White, fontSize = 28.sp)
val textStyleH2 = TextStyle(color = Color.White, fontSize = 20.sp)
val textStyleH3 = TextStyle(color = Color.White, fontSize = 12.sp)

@Composable
fun getImageWheater(wheater: String): Painter {
    return when (wheater) {
        WHEATER.SUNNY.name -> painterResource(id = R.drawable.ic_weather_sun)
        WHEATER.CLOUDY.name -> painterResource(id = R.drawable.ic_weather_cloud)
        WHEATER.RAIN.name -> painterResource(id = R.drawable.ic_weather_thunder)  // TODO falta la imagen, no esta en el xd
        WHEATER.STORM.name -> painterResource(id = R.drawable.ic_weather_thunder)
        else -> return painterResource(id = R.drawable.ic_weather_sun)
    }
}

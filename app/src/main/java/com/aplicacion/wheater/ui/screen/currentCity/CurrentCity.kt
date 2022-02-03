package com.aplicacion.wheater.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aplicacion.wheater.R
import com.aplicacion.wheater.ui.paddingEnd
import com.aplicacion.wheater.ui.paddingStart
import com.aplicacion.wheater.ui.theme.Bg_header_dark
import com.aplicacion.wheater.ui.theme.Bg_header_light
import com.aplicacion.wheater.ui.theme.textStyleH1
import com.aplicacion.wheater.ui.theme.textStyleH2
import com.aplicacion.wheater.ui.theme.textStyleH3

@Composable
fun CurrentCityScreen() {
    HeaderCurrentScreen()
    WheaterByHour()
    WheaterByDay()
}

@Composable
fun HeaderCurrentScreen() {
    Column(
        modifier = Modifier
            .background(color = if (isSystemInDarkTheme()) Bg_header_dark else Bg_header_light)
            .fillMaxWidth()
            .padding(top = 75.dp)
    ) {
        lineCityName()
        lineTemperatureAndOther()
    }
}

@Composable
fun lineCityName() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(start = paddingStart)) {
            Text(text = "Tandil", style = textStyleH1)
            Text(text = "Buenos Aires", style = textStyleH3, modifier = Modifier.padding(top = 17.dp))
            Text(text = "Argentina", style = textStyleH3)
        }
        Image(
            painter = painterResource(id = R.drawable.ic_weathers_clouds),
            contentDescription = "imgWheater",
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(end = paddingEnd)
        )
    }
}

@Composable
fun lineTemperatureAndOther() {
    var seeEndHeader by remember { mutableStateOf(false) }
    Column {
        Row(
            modifier = Modifier
                .wrapContentHeight()
                .padding(start = paddingStart, top = 17.dp)
        ) {
            Text(
                text = "25°C",
                style = textStyleH1,
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_umbrella),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 34.dp)
            )
            Text(
                text = "40%",
                style = textStyleH3,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.ic_wind),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 16.dp)
            )
            Text(
                text = "40%",
                style = textStyleH3,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 8.dp)
            )
            Image(painter = painterResource(id = R.drawable.ic_wind),   // TODO, NO FUNCIONA EL SVG EN EL XD
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .wrapContentWidth(align = Alignment.End)
                    .padding(end = paddingEnd)
                    .clickable {
                        seeEndHeader = seeEndHeader.not()
                    }
            )
        }
        if (seeEndHeader) {
            lineBarGraph()
        }
    }
}

@Composable
fun lineBarGraph() {

    // TODO ELEVAR AL VIEWMODEL
    val checkedState = remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Temperature vs. humidity", style = textStyleH2, modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = 30.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.current_city_switch_favorite))
            Switch(
                checked = checkedState.value,
                onCheckedChange = {
                    checkedState.value = it
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = false)
fun lala() {
    lineBarGraph()
}

// @Composable
// @Preview(showBackground = true, uiMode = UI_MODE_NIGHT_NO)
// fun previewHeader() {
//     HeaderCurrentScreen()
// }
//
// @Composable
// @Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
// fun previewHeader2(){
//     HeaderCurrentScreen()
// }

@Composable
fun WheaterByHour() {
}

@Composable
fun WheaterByDay() {
}



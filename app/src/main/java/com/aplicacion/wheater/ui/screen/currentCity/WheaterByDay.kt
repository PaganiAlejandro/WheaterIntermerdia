package com.aplicacion.wheater.ui.screen.currentCity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.aplicacion.wheater.data.entities.WheaterByDay
import com.aplicacion.wheater.data.entities.WheaterByHour
import com.aplicacion.wheater.ui.getImageWheater
import com.aplicacion.wheater.ui.paddingEnd
import com.aplicacion.wheater.ui.paddingStart
import com.aplicacion.wheater.ui.textStyleH2
import com.aplicacion.wheater.ui.textStyleH3
import com.aplicacion.wheater.ui.theme.textColor_probability

@Composable
fun listRowWheaterDay(wheaterByDay: List<WheaterByDay>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = paddingStart, end = paddingEnd, bottom = 20.dp)
    ) {
        items(wheaterByDay.size) { day ->
            itemWheaterDay(wheaterByDay = wheaterByDay.get(day))
        }
    }
}

// TODO El dia si es la actual poner NOW, o quizas viene asi en el servicio
@Composable
fun itemWheaterDay(wheaterByDay: WheaterByDay) {
    Row(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
    ) {
        Text(
            modifier = Modifier
                .weight(1f)
                .wrapContentWidth(align = Alignment.Start),
            text = wheaterByDay.day, style = textStyleH2
            )
        Row(modifier = Modifier
            .width(100.dp).wrapContentWidth(align = Alignment.CenterHorizontally)) {
            Image(painter = getImageWheater(wheaterByDay.wheater), contentDescription = "")
            Text(
                modifier = Modifier
                    .padding(start = 9.dp)
                    .align(Alignment.CenterVertically),
                text = wheaterByDay.probability, style = textStyleH3, color = textColor_probability, )
        }
        Text(
            modifier = Modifier
                .weight(0.8f)
                .wrapContentWidth(align = Alignment.End),
            text = wheaterByDay.temperature, style = textStyleH2,
            )
    }
}

@Composable
@Preview
fun previewlistRowWheaterDay() {
    itemWheaterDay(WheaterByDay("Tomorrow", "sunny", "0%", "28°"))
}
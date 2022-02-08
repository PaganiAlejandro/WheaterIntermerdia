package com.aplicacion.wheater.ui.screen.currentCity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aplicacion.wheater.data.entities.WheaterByHour
import com.aplicacion.wheater.ui.getImageWheater
import com.aplicacion.wheater.ui.paddingStart
import com.aplicacion.wheater.ui.textStyleH2
import com.aplicacion.wheater.ui.textStyleH3
import com.aplicacion.wheater.ui.theme.textColor_probability

@Composable
fun listRowWheaterHour(wheaterByHour: List<WheaterByHour>) {
    LazyRow(
        Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, start = paddingStart, bottom = 20.dp)
    ) {
        items(wheaterByHour.size) { favorite ->
            itemWheaterHour(wheaterByHour = wheaterByHour.get(favorite))
        }
    }
    Divider(color = textColor_probability,
        modifier = Modifier.fillMaxWidth().height(1.dp))
}

// TODO quizas aca de acuerdo a si viene o no la probabilidad o bien si es por el tiempo, no se muestra
// TODO LA hora si es la actual poner NOW, o quizas viene asi en el servicio
@Composable
fun itemWheaterHour(wheaterByHour: WheaterByHour) {
    Column(
        modifier = Modifier.padding(end = 20.dp).height(115.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.weight(1f).wrapContentHeight(align = Alignment.Top),
            text = wheaterByHour.hour,
            style = textStyleH2)
        Text(
            modifier = Modifier.weight(1f).wrapContentHeight(align = Alignment.Top),
            text = wheaterByHour.probability,
            style = textStyleH3,
            color = textColor_probability)
        Image(
            modifier = Modifier.height(27.dp).width(29.dp),
            painter = getImageWheater(wheaterByHour.wheater), contentDescription = ""
            )
        Text(
            modifier = Modifier.padding(top = 6.dp).weight(1f).wrapContentHeight(align = Alignment.Bottom),
            text = wheaterByHour.temperature,
            style = textStyleH2
            )
    }
}

@Composable
@Preview
fun previewWheaterByHour() {
    itemWheaterHour(WheaterByHour("10am", "sunny", "0%", "28°"))
}
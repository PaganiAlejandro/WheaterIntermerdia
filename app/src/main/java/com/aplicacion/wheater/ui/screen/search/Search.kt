package com.aplicacion.wheater.ui.screen.search

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aplicacion.wheater.R

@Composable
fun SearchScreen() {
    Surface(color = Color.White) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            LabelAndPlaceHolder()
        }
    }
}

@Composable
fun LabelAndPlaceHolder() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White),
            value = text,
            textStyle = TextStyle(color = Color.Gray, fontSize = 20.sp),
            onValueChange = { it ->
                text = it
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
            },
            placeholder = {
                Text(text = stringResource(id = R.string.bottom_bar_search))
            }
        )
        Divider(Modifier.height(2.dp), color = Color.Gray)
    }
}

@Preview
@Composable
fun previewSearch() {
    SearchScreen()
}
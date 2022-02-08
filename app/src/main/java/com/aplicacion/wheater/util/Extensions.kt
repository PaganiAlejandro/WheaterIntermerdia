package com.aplicacion.wheater.util

import android.text.Html
import android.text.Spanned

fun String.parseHtml(): Spanned =
    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N)
        Html.fromHtml(this, Html.FROM_HTML_MODE_COMPACT)
    else
        Html.fromHtml(this)
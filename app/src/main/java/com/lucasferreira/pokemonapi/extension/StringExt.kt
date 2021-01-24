package com.lucasferreira.pokemonapi.extension

import java.text.DecimalFormat

private fun dm() = DecimalFormat().apply { maximumFractionDigits = 1 }

fun Int.formatDecimeter() =
    if (this >= 10) {
        dm().format(div(10.0)) + "m"
    } else "${times(10)} cm"

fun Int.formatKilogram() =
    if (this >= 10) {
        dm().format(div(10f)) + "Kg"
    } else "${times(100)} g"


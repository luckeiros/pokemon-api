package com.lucasferreira.pokemonapi.extension

import java.text.DecimalFormat

private fun decimalFormat() = DecimalFormat().apply { maximumFractionDigits = 1 }

fun Int.formatDecimeter() =
    if (this >= 10) {
        decimalFormat().format(div(10.0)) + "m"
    } else "${times(10)} cm"

fun Int.formatKilogram() =
    if (this >= 10) {
        decimalFormat().format(div(10f)) + "Kg"
    } else "${times(100)} g"

fun String.pokemonId(): Int{
    return this.replace("v2", "").filter { it.isDigit() }.toInt()
}


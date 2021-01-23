package com.lucasferreira.pokemonapi.extension

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import java.util.*


fun View.turnVisible() {
    this.visibility = VISIBLE
}

fun View.turnGone() {
    this.visibility = GONE
}

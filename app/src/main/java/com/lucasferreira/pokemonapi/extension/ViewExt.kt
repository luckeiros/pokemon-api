package com.lucasferreira.pokemonapi.extension

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.lucasferreira.pokemonapi.Constants
import com.lucasferreira.pokemonapi.R
import com.squareup.picasso.Picasso


fun View.turnVisible() {
    this.visibility = VISIBLE
}

fun View.turnGone() {
    this.visibility = GONE
}

fun Chip.chipBackground(context: Context){
    this.chipBackgroundColor = ColorStateList.valueOf(ContextCompat.getColor(context, R.color.purple_color))
}

fun Chip.chipTextColor(){
    this.setTextColor(Color.WHITE)
}

fun showPokemonImage(id: Int, img: ImageView, context: Context){
    Picasso.get()
        .load(Constants.POKEMON_SPRITE_BASE_URL + id + context.resources.getString(R.string.png_extension))
        .placeholder(R.drawable.ic_placeholder)
        .error(R.drawable.ic_broken_img)
        .into(img)
}
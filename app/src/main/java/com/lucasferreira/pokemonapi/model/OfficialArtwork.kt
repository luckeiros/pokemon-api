package com.lucasferreira.pokemonapi.model

import com.google.gson.annotations.SerializedName

data class OfficialArtwork(
    @SerializedName("front_default")
    val imageUrl: String
)
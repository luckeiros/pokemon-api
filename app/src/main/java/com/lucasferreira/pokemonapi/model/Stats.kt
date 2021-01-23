package com.lucasferreira.pokemonapi.model

import com.google.gson.annotations.SerializedName

data class Stats(
    val stat: Stat,
    @SerializedName("base_stat")
    val baseStat: Int
)
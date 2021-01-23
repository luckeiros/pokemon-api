package com.lucasferreira.pokemonapi.model

data class PokemonResponse(
    val next: String,
    val results: List<Pokemon>
)
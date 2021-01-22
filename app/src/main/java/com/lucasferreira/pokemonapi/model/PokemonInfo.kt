package com.lucasferreira.pokemonapi.model

data class PokemonInfo(
    val abilities: List<Ability>,
    val forms: List<Forms>,
    val height: Int,
    val weight: Int,
    val types: List<Types>,
    val name: String,
    val moves: List<Move>
)

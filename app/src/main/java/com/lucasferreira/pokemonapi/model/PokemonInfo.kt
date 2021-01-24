package com.lucasferreira.pokemonapi.model

data class PokemonInfo(
    val abilities: List<Abilities>,
    val forms: List<Forms>,
    val height: Int,
    val weight: Int,
    val types: List<Types>,
    val sprites: Sprites,
    val name: String,
    val stats: List<Stats>
)

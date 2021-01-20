package com.lucasferreira.pokemonapi.feature.pokemonlist.repository

import com.lucasferreira.pokemonapi.model.Pokemon

interface PokemonRepository {

    suspend fun getPokemons() : List<Pokemon>
}
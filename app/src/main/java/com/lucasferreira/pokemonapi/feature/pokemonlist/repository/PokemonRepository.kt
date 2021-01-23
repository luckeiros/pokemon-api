package com.lucasferreira.pokemonapi.feature.pokemonlist.repository

import com.lucasferreira.pokemonapi.model.Pokemon
import com.lucasferreira.pokemonapi.model.PokemonResponse

interface PokemonRepository {

    suspend fun getPokemons() : PokemonResponse
    suspend fun getMorePokemons(url: String) : PokemonResponse
}
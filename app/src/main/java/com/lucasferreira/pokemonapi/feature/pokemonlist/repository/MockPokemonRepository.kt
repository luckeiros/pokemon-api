package com.lucasferreira.pokemonapi.feature.pokemonlist.repository

import com.lucasferreira.pokemonapi.model.Pokemon

class MockPokemonRepository : PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> {
        return listOf(Pokemon("Pokemon 1", ""))
    }
}
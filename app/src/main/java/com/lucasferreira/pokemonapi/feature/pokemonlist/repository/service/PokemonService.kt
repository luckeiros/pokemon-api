package com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service

import com.lucasferreira.pokemonapi.model.PokemonResponse
import retrofit2.http.GET

interface PokemonService {
    @GET("pokemon/")
    suspend fun getPokemon() : PokemonResponse
}
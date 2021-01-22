package com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service

import com.lucasferreira.pokemonapi.di.Endpoint
import com.lucasferreira.pokemonapi.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
    @GET(Endpoint.POKEMON_ENDPOINT)
    suspend fun getPokemon() : PokemonResponse

}
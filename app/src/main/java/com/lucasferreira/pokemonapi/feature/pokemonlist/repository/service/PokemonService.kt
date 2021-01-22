package com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service

import com.lucasferreira.pokemonapi.di.Endpoint
import com.lucasferreira.pokemonapi.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonService {
    @GET(Endpoint.POKEMON_ENDPOINT)
    suspend fun getPokemon(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonResponse

}
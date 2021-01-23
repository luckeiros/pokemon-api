package com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service

import com.lucasferreira.pokemonapi.di.Endpoint
import com.lucasferreira.pokemonapi.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface PokemonService {
    @GET(Endpoint.POKEMON_ENDPOINT)
    suspend fun getPokemon(): PokemonResponse

    @GET
    suspend fun getMorePokemons(@Url url: String) : PokemonResponse

}
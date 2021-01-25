package com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service

import com.lucasferreira.pokemonapi.Constants
import com.lucasferreira.pokemonapi.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface PokemonService {
    @GET(Constants.POKEMON_ENDPOINT)
    suspend fun getPokemon(): PokemonResponse

    @GET
    suspend fun getMorePokemons(@Url url: String): PokemonResponse
}
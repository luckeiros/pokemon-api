package com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service

import com.lucasferreira.pokemonapi.di.Endpoint
import com.lucasferreira.pokemonapi.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url

interface PokemonInfoService {
    @GET(Endpoint.POKEMON_INFO_ENDPOINT)
    suspend fun getPokemonInfo(@Path("id") id: String) : PokemonResponse
}
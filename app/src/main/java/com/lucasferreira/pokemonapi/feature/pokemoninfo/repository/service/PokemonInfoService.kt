package com.lucasferreira.pokemonapi.feature.pokemoninfo.repository.service

import com.lucasferreira.pokemonapi.di.Endpoint
import com.lucasferreira.pokemonapi.model.PokemonInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonInfoService {
    @GET(Endpoint.POKEMON_INFO_ENDPOINT)
    suspend fun getPokemonInfo(@Path("id") id: Int) : PokemonInfo
}
package com.lucasferreira.pokemonapi.feature.pokemoninfo.repository

import com.lucasferreira.pokemonapi.model.PokemonInfo

interface PokemonInfoRepository {
    suspend fun getPokemonInfo(id: Int): PokemonInfo
}
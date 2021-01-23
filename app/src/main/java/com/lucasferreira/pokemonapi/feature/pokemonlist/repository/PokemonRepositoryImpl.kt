package com.lucasferreira.pokemonapi.feature.pokemonlist.repository

import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service.PokemonService
import com.lucasferreira.pokemonapi.model.Pokemon
import com.lucasferreira.pokemonapi.model.PokemonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val retrofit: Retrofit) :
    PokemonRepository {

    override suspend fun getPokemons(): PokemonResponse = withContext(Dispatchers.IO){
        val service = retrofit.create(PokemonService::class.java)

        service.getPokemon()
    }

    override suspend fun getMorePokemons(url: String): PokemonResponse = withContext(Dispatchers.IO) {
        val service = retrofit.create(PokemonService::class.java)

        service.getMorePokemons(url)
    }
}
package com.lucasferreira.pokemonapi.feature.pokemonlist.repository

import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.service.PokemonService
import com.lucasferreira.pokemonapi.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(private val retrofit: Retrofit) :
    PokemonRepository {

    override suspend fun getPokemons(): List<Pokemon> = withContext(Dispatchers.IO){
        val service = retrofit.create(PokemonService::class.java)

        service.getPokemon().results
    }

}
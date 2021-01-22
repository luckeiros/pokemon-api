package com.lucasferreira.pokemonapi.feature.pokemoninfo.repository

import com.lucasferreira.pokemonapi.feature.pokemoninfo.repository.service.PokemonInfoService
import com.lucasferreira.pokemonapi.model.PokemonInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class PokemonInfoRepositoryImpl @Inject constructor(private val retrofit: Retrofit) :
    PokemonInfoRepository {

    override suspend fun getPokemonInfo(id: String): List<PokemonInfo> = withContext(Dispatchers.IO){
        val service = retrofit.create(PokemonInfoService::class.java)

        service.getPokemonInfo().results
    }
}
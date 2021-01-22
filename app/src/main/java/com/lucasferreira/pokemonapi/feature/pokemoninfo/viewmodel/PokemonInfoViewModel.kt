package com.lucasferreira.pokemonapi.feature.pokemoninfo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasferreira.pokemonapi.extension.emit
import com.lucasferreira.pokemonapi.extension.safeLaunch
import com.lucasferreira.pokemonapi.feature.pokemoninfo.repository.PokemonInfoRepository
import com.lucasferreira.pokemonapi.feature.pokemoninfo.viewstate.PokemonInfoState
import com.lucasferreira.pokemonapi.feature.pokemoninfo.viewstate.PokemonInfoViewState
import javax.inject.Inject

class PokemonInfoViewModel @Inject constructor(private val repository: PokemonInfoRepository) :
    ViewModel() {

    val viewState = PokemonInfoViewState(
        pokemonInfoState = MutableLiveData()
    )

    fun loadPokemonInfo() = safeLaunch {
        viewState.pokemonInfoState.emit(PokemonInfoState.Loading)
    }

    suspend fun getPokemonInfo(id: String){
        val pokemons = repository.getPokemonInfo(id)
    }
}
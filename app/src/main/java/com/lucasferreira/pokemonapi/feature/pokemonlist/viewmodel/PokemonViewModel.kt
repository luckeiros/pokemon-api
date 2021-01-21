package com.lucasferreira.pokemonapi.feature.pokemonlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasferreira.pokemonapi.extension.emit
import com.lucasferreira.pokemonapi.extension.safeLaunch
import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.PokemonRepository
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewstate.PokemonListState
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewstate.PokemonViewState
import javax.inject.Inject

class PokemonViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {

    val viewState = PokemonViewState(
            pokemonListState = MutableLiveData()
    )

    fun loadPokemons() = safeLaunch {
        viewState.pokemonListState.emit(PokemonListState.Loading)
        getPokemons()
    }

    private suspend fun getPokemons(){
        val pokemons = repository.getPokemons()
        viewState.pokemonListState.emit(PokemonListState.ListDisplayed(pokemons))
    }
}


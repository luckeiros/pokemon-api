package com.lucasferreira.pokemonapi.feature.pokemonlist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lucasferreira.pokemonapi.extension.emit
import com.lucasferreira.pokemonapi.extension.safeLaunch
import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.PokemonRepository
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewstate.PokemonListState
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewstate.PokemonViewState
import com.lucasferreira.pokemonapi.model.Pokemon
import javax.inject.Inject

class PokemonViewModel @Inject constructor(private val repository: PokemonRepository) : ViewModel() {

    val viewState = PokemonViewState(
        pokemonListState = MutableLiveData()
    )

    val pagination = MutableLiveData<List<Pokemon>>()
    var isLoading: Boolean = false

    lateinit var nextUrl: String

    fun loadPokemons() = safeLaunch {
        viewState.pokemonListState.emit(PokemonListState.Loading)
        getPokemons()
    }

    fun loadMorePokemons() = safeLaunch {
        isLoading = true
        val pokemons = repository.getMorePokemons(nextUrl)
        isLoading = false

        nextUrl = pokemons.next
        pagination.emit(pokemons.results)
    }

    private suspend fun getPokemons(){
        val pokemons = repository.getPokemons()
        nextUrl = pokemons.next
        viewState.pokemonListState.emit(PokemonListState.ListDisplayed(pokemons.results))
    }
}


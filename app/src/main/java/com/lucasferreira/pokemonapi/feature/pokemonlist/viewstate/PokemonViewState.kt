package com.lucasferreira.pokemonapi.feature.pokemonlist.viewstate

import androidx.lifecycle.LiveData
import com.lucasferreira.pokemonapi.model.Pokemon

class PokemonListViewState(
    val pokemonListState: LiveData<PokemonListState>
)

sealed class PokemonListState {
    object Loading : PokemonListState()
    object Error: PokemonListState()
    data class ListDisplayed(val pokemonList: List<Pokemon>) : PokemonListState()
}
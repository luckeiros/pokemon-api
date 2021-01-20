package com.lucasferreira.pokemonapi.feature.pokemonlist.viewmodel

import androidx.lifecycle.ViewModel
import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.PokemonRepository
import javax.inject.Inject

class PokemonViewModel @Inject constructor(private val repository: PokemonRepository) :
    ViewModel() {

        fun loadPokemons()
}
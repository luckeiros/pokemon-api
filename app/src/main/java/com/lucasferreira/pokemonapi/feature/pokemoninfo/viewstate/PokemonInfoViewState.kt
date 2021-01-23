package com.lucasferreira.pokemonapi.feature.pokemoninfo.viewstate

import androidx.lifecycle.LiveData
import com.lucasferreira.pokemonapi.model.PokemonInfo

class PokemonInfoViewState(
    val pokemonInfoState: LiveData<PokemonInfoState>
)

sealed class PokemonInfoState {
    object Loading: PokemonInfoState()
    object Error: PokemonInfoState()
    data class DataDisplayed(val pokemonInfo: PokemonInfo): PokemonInfoState()
}
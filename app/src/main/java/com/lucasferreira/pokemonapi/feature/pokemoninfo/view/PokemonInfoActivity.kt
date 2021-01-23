package com.lucasferreira.pokemonapi.feature.pokemoninfo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.lucasferreira.pokemonapi.R
import com.lucasferreira.pokemonapi.extension.observe
import com.lucasferreira.pokemonapi.extension.turnGone
import com.lucasferreira.pokemonapi.extension.turnVisible
import com.lucasferreira.pokemonapi.feature.pokemoninfo.viewmodel.PokemonInfoViewModel
import com.lucasferreira.pokemonapi.feature.pokemoninfo.viewstate.PokemonInfoState
import com.lucasferreira.pokemonapi.model.PokemonInfo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_pokemon_info.*
import javax.inject.Inject

@AndroidEntryPoint
class PokemonInfoActivity : AppCompatActivity() {

    @Inject
    lateinit var pokemonInfoViewModel: PokemonInfoViewModel
    val idMock: Int = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_info)

        observeStates()
        pokemonInfoViewModel.loadPokemonInfo(idMock)
    }

    private fun observeStates() {
        with(pokemonInfoViewModel.viewState) {
            observe(pokemonInfoState) {
                when (it) {
                    is PokemonInfoState.Loading -> setLoading()
                    is PokemonInfoState.DataDisplayed -> showPokemonInfo(it.pokemonInfo)
                    is PokemonInfoState.Error -> showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Erro ao carregar informações", Toast.LENGTH_LONG).show()
    }

    private fun showPokemonInfo(pokemonInfo: PokemonInfo) {
        pbPokemonInfo.turnGone()

        showAbilities(pokemonInfo)
        showTypes(pokemonInfo)
        showForms(pokemonInfo)
        showHeight(pokemonInfo)
        showWeight(pokemonInfo)
    }

    private fun setLoading() {
        pbPokemonInfo.turnVisible()
    }

    private fun showAbilities(pokemonInfo: PokemonInfo) {
        pokemonAbilitiesGroup.removeAllViews()
        pokemonInfo.abilities.map { it.ability.name }.forEach {
            pokemonAbilitiesGroup.addView(
                Chip(this, null, R.attr.chipStyle).apply {
                    text = it
                    isClickable = false
                }
            )
        }
    }

    private fun showTypes(pokemonInfo: PokemonInfo) {
        pokemonTypesGroup.removeAllViews()
        pokemonInfo.types.map { it.type.name }.forEach {
            pokemonTypesGroup.addView(
                Chip(this, null, R.attr.chipStyle).apply {
                    text = it
                    isClickable = false
                }
            )
        }
    }

    private fun showForms(pokemonInfo: PokemonInfo) {
        pokemonFormsGroup.removeAllViews()
        pokemonInfo.forms.map { it.name }.forEach {
            pokemonFormsGroup.addView(
                Chip(this, null, R.attr.chipStyle).apply {
                    text = it
                    isClickable = false
                }
            )
        }
    }

    private fun showHeight(pokemonInfo: PokemonInfo) {
        pokemonHeight.removeAllViews()
        val height = pokemonInfo.height.toString()
        pokemonHeight.addView(
            Chip(this, null, R.attr.chipStyle).apply {
                text = height
                isClickable = false
            }
        )
    }

    private fun showWeight(pokemonInfo: PokemonInfo) {
        pokemonWeight.removeAllViews()
        val weight = pokemonInfo.weight.toString()
        pokemonWeight.addView(
            Chip(this, null, R.attr.chipStyle).apply {
                text = weight
                isClickable = false
            }
        )
    }
}
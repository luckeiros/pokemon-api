package com.lucasferreira.pokemonapi.feature.pokemoninfo.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.Chip
import com.lucasferreira.pokemonapi.R
import com.lucasferreira.pokemonapi.extension.*
import com.lucasferreira.pokemonapi.feature.pokemoninfo.viewmodel.PokemonInfoViewModel
import com.lucasferreira.pokemonapi.feature.pokemoninfo.viewstate.PokemonInfoState
import com.lucasferreira.pokemonapi.model.PokemonInfo
import com.lucasferreira.pokemonapi.model.Stats
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_pokemon_info.*
import kotlinx.android.synthetic.main.pokemon_list_item.view.*
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class PokemonInfoActivity : AppCompatActivity() {

    @Inject
    lateinit var pokemonInfoViewModel: PokemonInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_info)

        observeStates()
        pokemonInfoViewModel.loadPokemonInfo(getId())
        returnToPokemonListActivity()
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
        rvPokemonStats.turnVisible()

        showAbilities(pokemonInfo)
        showTypes(pokemonInfo)
        showForms(pokemonInfo)
        showHeight(pokemonInfo)
        showWeight(pokemonInfo)
        showPokemonImage()
        showPokemonName(pokemonInfo)
        configureStatsRecyclerView(pokemonInfo.stats)
    }

    private fun configureStatsRecyclerView(stats: List<Stats>){
        rvPokemonStats.adapter = PokemonInfoAdapter(stats.toMutableList(), this)
    }

    private fun setLoading() {
        rvPokemonStats.turnGone()
        pbPokemonInfo.turnVisible()
    }

    private fun showAbilities(pokemonInfo: PokemonInfo) {
        pokemonAbilitiesGroup.removeAllViews()
        pokemonInfo.abilities.map { it.ability.name }.forEach {
            pokemonAbilitiesGroup.addView(
                Chip(this, null, R.attr.chipStyle).apply {
                    this.chipBackground(this@PokemonInfoActivity)
                    this.chipTextColor(this@PokemonInfoActivity)
                    text = it.capitalize(Locale.getDefault())
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
                    this.chipBackground(this@PokemonInfoActivity)
                    this.chipTextColor(this@PokemonInfoActivity)
                    text = it.capitalize(Locale.getDefault())
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
                    this.chipBackground(this@PokemonInfoActivity)
                    this.chipTextColor(this@PokemonInfoActivity)
                    text = it.capitalize(Locale.getDefault())
                    isClickable = false
                }
            )
        }
    }

    private fun showHeight(pokemonInfo: PokemonInfo) {
        tvHeight.text = pokemonInfo.height.formatDecimeter()
    }

    private fun showWeight(pokemonInfo: PokemonInfo) {
        tvWeight.text = pokemonInfo.weight.formatKilogram()
    }

    private fun showPokemonImage() {
        showPokemonImage(getId(), imgPokemonArtwork, this)
    }

    private fun showPokemonName(pokemonInfo: PokemonInfo){
        tvPokemonName.text = pokemonInfo.name.capitalize(Locale.getDefault())
    }

    private fun getId(): Int {
        val id = intent.getStringExtra("id").toString()
        return id.toInt()
    }

    private fun returnToPokemonListActivity() {
        icBack.setOnClickListener {
            finish()
        }
    }

}
package com.lucasferreira.pokemonapi.feature.pokemonlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lucasferreira.pokemonapi.R
import com.lucasferreira.pokemonapi.extension.observe
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewmodel.PokemonViewModel
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewstate.PokemonListState
import com.lucasferreira.pokemonapi.model.Pokemon
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class PokemonListActivity : AppCompatActivity() {
    @Inject
    lateinit var pokemonViewModel: PokemonViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeStates()
        pokemonViewModel.loadPokemons()
    }

    private fun observeStates(){
        with(pokemonViewModel.viewState){
            observe(pokemonListState){
                when(it){
                    is PokemonListState.Loading -> setLoading()
                    is PokemonListState.ListDisplayed -> showPokemons(it.pokemonList)
                    is PokemonListState.Error -> showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Erro ao carregar lista", Toast.LENGTH_LONG).show()
    }

    private fun showPokemons(pokemonList: List<Pokemon>) {
        pbPokemonList.visibility = View.GONE
        rvPokemon.visibility = View.VISIBLE

        rvPokemon.adapter = PokemonListAdapter(pokemonList, this)
    }

    private fun setLoading() {
        rvPokemon.visibility = View.GONE
        pbPokemonList.visibility = View.VISIBLE
    }
}
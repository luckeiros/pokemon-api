package com.lucasferreira.pokemonapi.feature.pokemonlist.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.lucasferreira.pokemonapi.R
import com.lucasferreira.pokemonapi.extension.observe
import com.lucasferreira.pokemonapi.extension.turnGone
import com.lucasferreira.pokemonapi.extension.turnVisible
import com.lucasferreira.pokemonapi.feature.pokemoninfo.view.PokemonInfoActivity
import com.lucasferreira.pokemonapi.feature.pokemonlist.listener.PaginationScrollListener
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewmodel.PokemonViewModel
import com.lucasferreira.pokemonapi.feature.pokemonlist.viewstate.PokemonListState
import com.lucasferreira.pokemonapi.model.Pokemon
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_pokemon_list.*
import javax.inject.Inject


@AndroidEntryPoint
class PokemonListActivity : AppCompatActivity() {
    @Inject
    lateinit var pokemonViewModel: PokemonViewModel
    lateinit var id: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon_list)

        configureRecyclerViewListener()
        observeStates()
        pokemonViewModel.loadPokemons()
    }

    private fun configureRecyclerViewListener() {
        rvPokemon.addOnScrollListener(object : PaginationScrollListener(rvPokemon.layoutManager as LinearLayoutManager) {

            override fun isLoading(): Boolean {
                return pokemonViewModel.isLoading
            }

            override fun loadMoreItems() {
                pokemonViewModel.loadMorePokemons()
            }
        })
    }

    private fun observeStates() {
        with(pokemonViewModel.viewState) {
            observe(pokemonListState) {
                when (it) {
                    is PokemonListState.Loading -> setLoading()
                    is PokemonListState.ListDisplayed -> showPokemons(it.pokemonList)
                    is PokemonListState.Error -> showError()
                }
            }
        }


        observe(pokemonViewModel.pagination) {
            val adapter = rvPokemon.adapter as PokemonListAdapter
            adapter.addData(it)
        }
    }

    private fun showError() {
        Toast.makeText(this, "Erro ao carregar lista", Toast.LENGTH_LONG).show()
    }

    private fun showPokemons(pokemonList: List<Pokemon>) {
        pbPokemonList.turnGone()
        rvPokemon.turnVisible()

        rvPokemon.adapter = PokemonListAdapter(pokemonList.toMutableList(), this, onPokemonClickedListener)
    }

    private fun setLoading() {
        rvPokemon.turnGone()
        pbPokemonList.turnVisible()
    }

    private val onPokemonClickedListener: (Pokemon) -> Unit = {
        val url = it.url.replace("v2", "")
        id = url.filter { it.isDigit() }
        val intent = Intent(this, PokemonInfoActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}
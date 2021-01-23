package com.lucasferreira.pokemonapi.feature.pokemonlist.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasferreira.pokemonapi.R
import com.lucasferreira.pokemonapi.model.Pokemon
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonListAdapter(private val pokemon: MutableList<Pokemon>, private val context: Context) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false)

        return PokemonListViewHolder(view)
    }

    fun addData(pokemons: List<Pokemon>) {
        val size = this.pokemon.size
        this.pokemon.addAll(pokemons)
        val sizeNew = this.pokemon.size
        notifyItemRangeChanged(size, sizeNew)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bindView(pokemon[position])
        holder.getPokemonImage(pokemon[position])
    }

    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pokemon: Pokemon) {
            itemView.tvPokemon.text = pokemon.name
        }

        fun getPokemonImage(pokemon: Pokemon) {
            val url = pokemon.url.replace("v2", "")
            val id = url.filter { it.isDigit() }
            Picasso.get()
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png")
                .into(itemView.imgPokemon)
        }

    }

}
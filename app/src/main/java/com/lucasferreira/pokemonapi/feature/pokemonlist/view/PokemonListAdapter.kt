package com.lucasferreira.pokemonapi.feature.pokemonlist.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasferreira.pokemonapi.R
import com.lucasferreira.pokemonapi.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_list_item.view.*

class PokemonListAdapter(private val pokemon: List<Pokemon>, private val context: Context) :
    RecyclerView.Adapter<PokemonListAdapter.PokemonListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false)

        return PokemonListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pokemon.size
    }

    override fun onBindViewHolder(holder: PokemonListViewHolder, position: Int) {
        holder.bindView(pokemon[position])
    }

    class PokemonListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(pokemon: Pokemon) {
            itemView.tvPokemon.text = pokemon.name
        }
}

}
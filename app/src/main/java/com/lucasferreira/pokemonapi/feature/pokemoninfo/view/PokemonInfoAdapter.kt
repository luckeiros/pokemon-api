package com.lucasferreira.pokemonapi.feature.pokemoninfo.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lucasferreira.pokemonapi.R
import com.lucasferreira.pokemonapi.model.Stats
import kotlinx.android.synthetic.main.pokemon_stats_list_item.view.*
import java.util.*
import javax.inject.Inject

class PokemonInfoAdapter @Inject constructor(
    private val stats: List<Stats>,
    private val context: Context
) : RecyclerView.Adapter<PokemonInfoAdapter.PokemonInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonInfoViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.pokemon_stats_list_item, parent, false)

        return PokemonInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PokemonInfoViewHolder, position: Int) {
        holder.bindView(stats[position])
    }

    override fun getItemCount(): Int {
        return stats.size
    }

    inner class PokemonInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(stats: Stats) {
            itemView.tvPokemonStatName.text = stats.stat.name.capitalize(Locale.getDefault())
            itemView.tvPokemonStat.text = stats.baseStat.toString()
        }

    }

}
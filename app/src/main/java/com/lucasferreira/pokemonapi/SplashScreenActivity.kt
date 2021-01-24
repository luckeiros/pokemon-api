package com.lucasferreira.pokemonapi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.lucasferreira.pokemonapi.feature.pokemonlist.view.PokemonListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        setOpenTime()
    }

    private fun openPokemonListActivity() {
        val intent = Intent(this, PokemonListActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun setOpenTime() {
        val handler = Handler()
        handler.postDelayed({
            openPokemonListActivity()
        }, 2500)

    }
}
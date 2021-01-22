package com.lucasferreira.pokemonapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucasferreira.pokemonapi.feature.pokemonlist.view.PokemonListActivity
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Executors.newSingleThreadScheduledExecutor().schedule({
            val intent = Intent(this, PokemonListActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000, TimeUnit.MILLISECONDS)

    }

}
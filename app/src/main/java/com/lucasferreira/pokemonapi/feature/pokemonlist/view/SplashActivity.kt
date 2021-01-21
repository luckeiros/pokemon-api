package com.lucasferreira.pokemonapi.feature.pokemonlist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.HandlerThread
import android.os.Looper
import com.lucasferreira.pokemonapi.R
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.logging.Handler

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
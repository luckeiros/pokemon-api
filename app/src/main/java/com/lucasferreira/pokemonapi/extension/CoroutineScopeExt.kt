package com.lucasferreira.pokemonapi.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

fun ViewModel.safeLaunch(
    block: suspend CoroutineScope.() -> Unit
) = viewModelScope.safeLaunch(block)

fun CoroutineScope.safeLaunch(block: suspend CoroutineScope.() -> Unit) {
    launch {
        try {
            block.invoke(this)
        } catch (e: Exception) {
            println("Deu erro")
        }
    }
}
package com.lucasferreira.pokemonapi.extension

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, action: (t: T) -> Unit) {
    liveData.observe(this, Observer { it?.let { action(it)} })
}

@MainThread
fun <T> LiveData<T>.emit(value: T) {
    require(this is MutableLiveData) { "$this isn't a valid MutableLiveData instance"}

    this.value = value
}
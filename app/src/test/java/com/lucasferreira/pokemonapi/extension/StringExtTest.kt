package com.lucasferreira.pokemonapi.extension

import junit.framework.Assert.assertEquals
import org.junit.Test

class StringExtTest {

    @Test
    fun whenPassUrlWithIdShouldExtractId() {
        val idFromUrl = "https://pokeapi.co/api/v2/pokemon/1"
        val idInt = idFromUrl.pokemonId()

        assertEquals(1, idInt)
    }
}
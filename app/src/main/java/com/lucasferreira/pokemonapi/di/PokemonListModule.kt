package com.lucasferreira.pokemonapi.di

import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.PokemonRepository
import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class PokemonListModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Endpoint.POKEMON_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePokemonRepository(retrofit: Retrofit): PokemonRepository {
        return PokemonRepositoryImpl(retrofit)
    }
}
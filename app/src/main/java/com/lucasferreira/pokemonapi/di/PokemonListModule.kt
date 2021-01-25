package com.lucasferreira.pokemonapi.di

import com.lucasferreira.pokemonapi.Constants
import com.lucasferreira.pokemonapi.feature.pokemoninfo.repository.PokemonInfoRepository
import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.PokemonRepository
import com.lucasferreira.pokemonapi.feature.pokemonlist.repository.PokemonRepositoryImpl
import com.lucasferreira.pokemonapi.feature.pokemoninfo.repository.PokemonInfoRepositoryImpl
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
            .baseUrl(Constants.POKEMON_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePokemonRepository(retrofit: Retrofit): PokemonRepository {
        return PokemonRepositoryImpl(retrofit)
    }

    @Provides
    fun providePokemonInfoRepository(retrofit: Retrofit): PokemonInfoRepository {
        return PokemonInfoRepositoryImpl(retrofit)
    }


}
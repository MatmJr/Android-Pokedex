package br.com.android_pokedex.api

import android.util.Log
import br.com.android_pokedex.api.model.PokemonApiResult
import br.com.android_pokedex.api.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonRepository {
    private val service: PokemonService
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(PokemonService::class.java)
    }

    fun listPokemons(limit: Int = 151): PokemonsApiResult?{
        val call = service.listPokemons(limit)

        return call.execute().body()
    }

    fun getPokemons(number: Int): PokemonApiResult?{
        val call = service.getPokemon(number)

        return call.execute().body()
    }
}
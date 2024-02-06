package br.com.android_pokedex.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.android_pokedex.api.PokemonRepository
import br.com.android_pokedex.domain.Pokemon

class PokemonViewModel : ViewModel() {

    var pokemons = MutableLiveData<List<Pokemon?>>()

    init {
        Thread(Runnable {
            loadPokemons()
        }).start()
    }

    private fun loadPokemons() {
        val pokemonsApiResult = PokemonRepository.listPokemons()

        pokemonsApiResult?.results?.let {

            pokemons.postValue(it.map{pokemonResult ->
                val number = pokemonResult.url
                    .replace("https://pokeapi.co/api/v2/pokemon/","")
                    .replace("/","").toInt()

                val pokemonApiResult = PokemonRepository.getPokemons(number)

                pokemonApiResult?.let {
                    Pokemon(
                        pokemonApiResult.id,
                        pokemonApiResult.name,
                        pokemonApiResult.types.map{type ->
                            type.type
                        }
                    )
                }
            })
        }
    }
}
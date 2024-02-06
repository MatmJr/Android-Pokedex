package br.com.android_pokedex.api.model

import br.com.android_pokedex.domain.Pokemon
import br.com.android_pokedex.domain.PokemonType

class PokemonsApiResult (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult(
    val name: String,
    val url: String
)

data class PokemonApiResult(
    val id: Int,
    val name: String,
    val types: List<PokemonTypeSlot>
)
data class PokemonTypeSlot(
    val slot: Int,
    val type: PokemonType
)
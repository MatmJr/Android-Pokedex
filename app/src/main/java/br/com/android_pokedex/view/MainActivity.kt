package br.com.android_pokedex.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.android_pokedex.R
import br.com.android_pokedex.domain.Pokemon
import br.com.android_pokedex.domain.PokemonType

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemon)

        val pokemons = listOf(
            Pokemon(
                "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png",
                1,
                "Bulbasaur",
                listOf(PokemonType("Grass"),PokemonType("Poison"))
            )
        )

        val layoutManager = LinearLayoutManager(this)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = PokemonAdapter(pokemons)
    }
}
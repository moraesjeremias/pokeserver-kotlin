package com.moraesjeremias.pokeserver.routes

import com.moraesjeremias.pokeserver.integration.pokemons.service.PokemonService
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val pokemonService by inject<PokemonService>()
    // Starting point for a Ktor app:
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get("/pokemon/{id}"){
            val pokemonId = call.parameters["id"]?.toInt()
            pokemonService.getPokemon(pokemonId)
        }
    }


}

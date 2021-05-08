package com.moraesjeremias.pokeserver.integration.pokemons.service

import com.moraesjeremias.pokeserver.config.AppProperties
import com.moraesjeremias.pokeserver.integration.pokemons.model.PokemonModel
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

class PokemonService(
    private val httpClient: HttpClient,
    private val appProperties: AppProperties
){


    suspend fun getPokemons(limit: Int, offset: Int){
//        val po
        httpClient.get<PokemonModel>(
            url = URLBuilder(appProperties.pokeapi.host).path("pokemon").build()
        )
    }
    suspend fun getPokemon(id: Int?){
        httpClient.get<PokemonModel>(
            url = URLBuilder(appProperties.pokeapi.host).path("pokemon/$id").build()
        )
    }
}
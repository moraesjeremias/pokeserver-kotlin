package com.moraesjeremias.pokeserver.integration.pokemons.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonModel(
    val id: String,
    val name: String,
    val sprites: SpriteType,
    val types: List<PokemonType>
)

@Serializable
data class PokemonType(
    val type: PokemonTypeName
)

@Serializable
data class PokemonTypeName(
    val name: String
)

@Serializable
data class SpriteType(
    @SerialName("other")
    val spriteType: PokemonSpriteType
)

@Serializable
data class PokemonSpriteType(
    @SerialName("official-artwork")
    val artwork: PokemonArtwork
)

@Serializable
data class PokemonArtwork(
    @SerialName("front_default")
    val imageURL: String
)
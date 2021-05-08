package com.moraesjeremias.pokeserver.config

import com.moraesjeremias.pokeserver.integration.pokemons.service.PokemonService
import io.ktor.client.*
import io.ktor.client.engine.jetty.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.util.*
import org.koin.core.module.Module
import org.koin.dsl.module
import org.koin.experimental.builder.single

@OptIn(KtorExperimentalAPI::class)
fun configModule() : Module {
    val httpClient = HttpClient(Jetty){
        engine {
            pipelining = true
            threadsCount = 4
        }
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.INFO
        }
        install(JsonFeature){
            serializer = KotlinxSerializer(jsonConfig)
        }
    }
    return module {
        single { httpClient }
        single { AppProperties.configApp() }
        single<PokemonService>()
    }
}
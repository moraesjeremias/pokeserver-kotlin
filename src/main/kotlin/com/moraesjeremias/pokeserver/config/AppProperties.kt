package com.moraesjeremias.pokeserver.config

import com.moraesjeremias.pokeserver.routes.configureRouting
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import io.github.config4k.extract
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.serialization.*
import kotlinx.serialization.json.Json
import mu.KotlinLogging
import org.koin.core.module.Module
import org.koin.ktor.ext.Koin
import org.koin.logger.SLF4JLogger
import org.slf4j.event.Level

private val logger = KotlinLogging.logger {}

val jsonConfig = Json{
    isLenient = true
    allowStructuredMapKeys = true
    encodeDefaults = true
    ignoreUnknownKeys = true
}

data class PokeApi(
    val host: String
)

data class AppProperties(
    val pokeapi: PokeApi
){
    companion object{
        fun configApp(): AppProperties {
            val config: Config = ConfigFactory.load()
            logger.info { "Loading config extraction: ${config.origin().description()}" }
            return config.extract("app")
        }
    }
}

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(vararg koinModules: Module = arrayOf(configModule())) {
    configureRouting()
    install(ContentNegotiation){
        register(ContentType.Application.Json, SerializationConverter(jsonConfig))
    }
    install(Koin){
        logger(
            SLF4JLogger(
                level = org.koin.core.logger.Level.ERROR
            )
        )
        modules(*koinModules)
    }
    install(CallLogging){
        level = Level.INFO
        filter { call -> !call.request.path().startsWith("/status") }
    }
}
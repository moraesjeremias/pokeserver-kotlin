package com.moraesjeremias.pokeserver

import io.ktor.application.*
import com.moraesjeremias.pokeserver.routes.*

fun main(args: Array<String>): Unit {
    io.ktor.server.netty.EngineMain.main(args)
}
@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    configureRouting()
}

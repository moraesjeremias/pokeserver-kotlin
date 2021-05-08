package com.moraesjeremias.pokeserver

import io.ktor.application.*
import com.moraesjeremias.pokeserver.routes.*

fun main(args: Array<String>): Unit {
    io.ktor.server.netty.EngineMain.main(args)
}

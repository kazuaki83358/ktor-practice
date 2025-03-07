package com.example

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        json()  // Enable JSON serialization using kotlinx.serialization
    }
    routing {
        get("/json/kotlinx-serialization") {
                call.respond(mapOf("hello" to "world"))
            }
    }
}

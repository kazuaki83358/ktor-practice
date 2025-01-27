package com.Handling

import com.Handling.model.User
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        post("/user") {
            val user = call.receive<User>()
            call.respondText("Hello, ${user.name}, you are ${user.age} years old!")
        }
        get("/users"){
            val user = call.respond(
                listOf(
                    User("Nishant",20),
                    User("Rahul",30),
                    User("Jadu",40),
                    User("Rohit",50)
                )
            )
        }
    }
}

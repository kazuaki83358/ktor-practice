package com.example

import com.example.model.Priority
import com.example.model.Task
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.http.content.staticResources

fun Application.configureRouting() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            call.respondText(text = "500: $cause" , status = HttpStatusCode.InternalServerError)
        }
    }
    routing {
        staticResources("/static", "static")
        get("/") {
            call.respondText("static")
        }
        get ("/task"){
            val task = call.respond(
                listOf(
                    Task("Sleeping",Priority.High),
                    Task("Eating",Priority.Medium),
                    Task("Coding",Priority.High),
                    Task("Study",Priority.Low),
                )
            )
        }
    }
}

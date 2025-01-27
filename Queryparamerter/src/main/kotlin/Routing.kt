package com.handling

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.Thymeleaf
import io.ktor.server.thymeleaf.ThymeleafContent
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun Application.configureRouting() {
    routing {
        //here root endpoint
        get("/") {
            call.respondText { "hello, Everyone!" }
        }
        //here is the hello endpoint with query parameter http://localhost:8080/hello?name=Nishant
        get("/hello") {
            val name = call.request.queryParameters["name"]?:"guest"
            call.respondText { "hello, $name !" }
        }
        //here is the /user endpoint for direct parameter endpoint http://localhost:8080/user/Nishant
        get("/user/{username?}") {  // Note the `?` makes {username} optional
            val username = call.parameters["username"] ?: "unknown"
            call.respondText("Welcome, $username!")
        }
        // Static plugin. Try to access `/static/index.html`
        staticResources("/static", "static")
    }
}

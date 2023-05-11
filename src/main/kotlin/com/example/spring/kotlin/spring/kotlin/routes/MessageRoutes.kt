package com.example.spring.kotlin.spring.kotlin.routes

import com.example.spring.kotlin.spring.kotlin.model.Message
import com.example.spring.kotlin.spring.kotlin.model.Origin
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.flowOf
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.*

val messagesRoutes: RouterFunction<ServerResponse> =
    coRouter {
        val messages = flowOf(
            Message(1, "This is the first message", Origin.POSTMAN),
            Message(2, "This is the second message", Origin.CURL)
        )

        "/messages".nest {
            GET("/flow") {
                val response = flowOf("This", " is", " a", " message")
                ServerResponse.ok().json().bodyAndAwait(response)
            }

            GET("/one") {
                val response = "This is a message from functional endpoint!!"
                ServerResponse.ok().json().bodyValueAndAwait(response)
            }

            GET("{id}") { request ->
                val id = request.pathVariable("id")
                messages.firstOrNull{ it.id.toString() == id }?.let { ok().json().bodyValueAndAwait(it) } ?: notFound().buildAndAwait()
            }

            GET("") { ok().bodyAndAwait(messages) }

            POST("") { request ->
                val message = request.awaitBody<Message>()
                ok().contentType(MediaType.APPLICATION_JSON).bodyValueAndAwait(message)
            }
        }
    }

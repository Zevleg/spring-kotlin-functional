package com.example.spring.kotlin.spring.kotlin.routes

import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.ServerResponse

val routes: RouterFunction<ServerResponse> =
    healtRoutes
        .and(messagesRoutes)

package com.example.spring.kotlin.spring.kotlin.routes

import org.springframework.web.reactive.function.server.bodyValueAndAwait
import org.springframework.web.reactive.function.server.coRouter

val healtRoutes = coRouter {
    GET("/health") { ok().bodyValueAndAwait("Healthy!") }
}

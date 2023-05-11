package com.example.spring.kotlin.spring.kotlin.config

import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.netty.http.server.HttpServer

private const val PORT: Int = 9090
private const val HOST: String = "0.0.0.0"

data class Config(
    val server: Server = Server()
) {
    data class Server(
        val host: String = System.getenv("HOST") ?: HOST,
        val port: Int = System.getenv("PORT")?.toIntOrNull() ?: PORT
    )
}

fun start(server: Config.Server, routes: RouterFunction<ServerResponse>) {
    val adapter = ReactorHttpHandlerAdapter(
        RouterFunctions
            .toHttpHandler(routes)
    )

    HttpServer
        .create()
        .port(server.port)
        .host(server.host)
        .handle(adapter)
        .bind()
        .block()
}

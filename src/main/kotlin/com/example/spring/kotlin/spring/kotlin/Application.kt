package com.example.spring.kotlin.spring.kotlin

import com.example.spring.kotlin.spring.kotlin.config.Config
import com.example.spring.kotlin.spring.kotlin.config.start
import com.example.spring.kotlin.spring.kotlin.routes.routes
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args) {
        val config = Config()
        start(config.server, routes)
    }
}
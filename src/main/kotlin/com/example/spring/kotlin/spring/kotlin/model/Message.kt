package com.example.spring.kotlin.spring.kotlin.model

data class Message(val id: Int, val content: String, val origin: Origin)

enum class Origin {
    POSTMAN, CURL, OTHER
}

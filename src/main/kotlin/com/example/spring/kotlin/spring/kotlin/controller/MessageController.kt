package com.example.spring.kotlin.spring.kotlin.controller

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
//@Controller
@RequestMapping("/messages")
class MessageController {

    @GetMapping
    //@ResponseBody
    fun all(): Flow<String> =
        flowOf("This", " is", " a", " message")

    @GetMapping("/one")
    //@ResponseBody
    fun one(): String = "This is a message"
}
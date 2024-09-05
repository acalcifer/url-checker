package com.url.checker.springboot.urlcheck.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class Hello {
    @GetMapping("hello")
    fun hello(): String {
        return "Hello there"
    }
}
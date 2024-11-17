package com.url.checker.springboot.urlcheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication
@EnableCaching
class UrlcheckApplication

fun main(args: Array<String>) {
	runApplication<UrlcheckApplication>(*args)
}

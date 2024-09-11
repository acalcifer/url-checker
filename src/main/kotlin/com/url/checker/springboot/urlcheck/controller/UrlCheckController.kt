package com.url.checker.springboot.urlcheck.controller

import com.url.checker.springboot.urlcheck.model.UrlCheckRequest
import com.url.checker.springboot.urlcheck.service.UrlCheckService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UrlCheckController(@Autowired val urlCheckService: UrlCheckService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @PostMapping("/check-url")
    fun checkUrl(@RequestBody urlCheckRequest: UrlCheckRequest): Boolean {
        return urlCheckService.checkUrlAndSave(urlCheckRequest.url)
    }
}
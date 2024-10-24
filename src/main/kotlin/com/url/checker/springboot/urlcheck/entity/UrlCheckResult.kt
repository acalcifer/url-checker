package com.url.checker.springboot.urlcheck.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column
import java.time.LocalDateTime
import java.util.UUID

@Entity
data class UrlCheckResult(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: UUID = UUID.randomUUID(),

    @Column(nullable = false)
    val url: String,

    @Column(nullable = false)
    val isReachable: Boolean,

    @Column(nullable = false)
    val checkedAt: LocalDateTime = LocalDateTime.now()
)


package com.url.checker.springboot.urlcheck.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Column
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
data class UrlCheckResult(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val url: String,

    @Column(name = "is_reachable", nullable = false)
    val isReachable: Boolean,

    @Column(name = "checked_at", nullable = false)
    val checkedAt: LocalDateTime = LocalDateTime.now()
)


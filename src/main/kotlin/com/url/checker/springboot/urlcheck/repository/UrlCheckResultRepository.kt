package com.url.checker.springboot.urlcheck.repository

import com.url.checker.springboot.urlcheck.model.UrlCheckResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
interface UrlCheckResultRepository : JpaRepository<UrlCheckResult, UUID> {
    fun findByUrl(url: String): Optional<UrlCheckResult>
}

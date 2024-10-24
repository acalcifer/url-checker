package com.url.checker.springboot.urlcheck.repository

import com.url.checker.springboot.urlcheck.model.UrlCheckResult
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UrlCheckResultRepository : JpaRepository<UrlCheckResult, Long>

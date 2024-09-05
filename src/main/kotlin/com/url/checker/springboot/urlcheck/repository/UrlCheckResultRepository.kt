package com.example.demo.repository

import com.example.demo.model.UrlCheckResult
import org.springframework.data.jpa.repository.JpaRepository

interface UrlCheckResultRepository : JpaRepository<UrlCheckResult, Long>

package com.url.checker.springboot.urlcheck.service

import com.url.checker.springboot.urlcheck.model.UrlCheckResult
import com.url.checker.springboot.urlcheck.repository.UrlCheckResultRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.net.HttpURLConnection
import java.net.URI
import java.time.LocalDateTime

@Service
class UrlCheckService @Autowired constructor(
    private val urlCheckResultRepository: UrlCheckResultRepository
) {
    fun isUrlExist(urlString: String): Boolean {
        try {
            var formattedUrl = urlString
            if (!formattedUrl.startsWith("http://") && !formattedUrl.startsWith("https://")) {
                formattedUrl = "http://$formattedUrl"
            }

            val uri = URI(formattedUrl)
            val url = uri.toURL()

            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "HEAD"
                connectTimeout = 5000
                readTimeout = 5000
                return responseCode in 200..399
            }
        } catch (_e: Exception) {
            return false
        }
    }

    fun checkUrlAndSave(urlString: String): Boolean {
        val isReachable = isUrlExist(urlString)

        // Save the result to the database
        val urlStatus = UrlCheckResult(
            url = urlString,
            isReachable = isReachable,
            checkedAt = LocalDateTime.now()
        )
        urlCheckResultRepository.save(urlStatus)
        
        return isReachable
    }
}
package com.url.checker.springboot.urlcheck.service

import com.url.checker.springboot.urlcheck.model.UrlCheckResult
import com.url.checker.springboot.urlcheck.repository.UrlCheckResultRepository
import org.springframework.stereotype.Service
import java.net.HttpURLConnection
import java.net.URI
import java.time.LocalDateTime.now

@Service
class UrlCheckService constructor(
    private val urlCheckResultRepository: UrlCheckResultRepository
) {
    companion object {
        private const val REQUEST_HEAD = "HEAD"
        private const val CONNECTION_TIMEOUT = 5000
        private const val READ_TIMEOUT = 5000
    }

    fun checkUrlWithProtocol(urlWithProtocol: String): Boolean {
        try {
            val url = URI(urlWithProtocol).toURL()

            return with(url.openConnection() as HttpURLConnection) {
                requestMethod = REQUEST_HEAD
                connectTimeout = CONNECTION_TIMEOUT
                readTimeout = READ_TIMEOUT
                return responseCode in 200..399
            }
        } catch (_: Exception) {
            return false
        }
    }

    fun isUrlExist(urlString: String): Boolean {
        try {
            var formattedUrl = urlString
            if (!formattedUrl.startsWith("http://") && !formattedUrl.startsWith("https://")) {
                formattedUrl = "https://$formattedUrl"
            }
            return checkUrlWithProtocol(formattedUrl) || checkUrlWithProtocol("http://$formattedUrl")

        } catch (_: Exception) {
            return false
        }
    }

    fun checkUrlAndSave(urlString: String): Boolean {
        val foundedUrl = urlCheckResultRepository.findByUrl(urlString)
        if (foundedUrl.isPresent) {
            return foundedUrl.get().isReachable
        }
        val isReachable = isUrlExist(urlString)

        // Save the result to the database
        val urlStatus = UrlCheckResult(
            url = urlString,
            isReachable = isReachable,
            checkedAt = now()
        )
        urlCheckResultRepository.save(urlStatus)

        return isReachable
    }
}
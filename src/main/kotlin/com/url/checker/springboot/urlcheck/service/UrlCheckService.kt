package com.url.checker.springboot.urlcheck.service

import org.springframework.stereotype.Service
import java.net.HttpURLConnection
import java.net.URI

@Service
class UrlCheckService {
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
}
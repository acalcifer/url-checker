package com.url.checker.springboot.urlcheck.service

import org.springframework.stereotype.Service
import java.net.HttpURLConnection
import java.net.URI

@Service
class UrlCheckService {
    fun isUrlExist(urlString: String): Boolean {
        try {
            var parsedUrlString = urlString
            if (!parsedUrlString.contains("http")) {
                val sb = StringBuilder()
                sb.append("http://").append(parsedUrlString)
                parsedUrlString = sb.toString()
            }
            val url = URI(parsedUrlString).toURL()
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "HEAD"
            connection.connectTimeout = 3000
            connection.readTimeout = 3000
            connection.connect()
            return true
        } catch (err: Error) {
            return false
        }
    }
}
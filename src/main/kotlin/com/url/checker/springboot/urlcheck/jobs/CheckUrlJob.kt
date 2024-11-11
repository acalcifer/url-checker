package com.url.checker.springboot.urlcheck.jobs

import com.url.checker.springboot.urlcheck.repository.UrlCheckResultRepository
import com.url.checker.springboot.urlcheck.service.UrlCheckService
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.quartz.Job
import org.quartz.JobExecutionContext
import org.springframework.beans.factory.annotation.Autowired
import java.time.LocalDateTime.now

class CheckUrlJob : Job {
    private val logger: Logger = LogManager.getLogger(this.javaClass)

    @Autowired
    private lateinit var urlCheckResultRepository: UrlCheckResultRepository

    @Autowired
    private lateinit var urlCheckService: UrlCheckService

    override fun execute(context: JobExecutionContext) {
        val allUrls = urlCheckResultRepository.findAll()

        val updatedUrlRecords = allUrls.map { urlRecord ->
            val isReachable = urlCheckService.isUrlExist(urlRecord.url)
            urlRecord.copy(isReachable = isReachable, checkedAt = now())
        }
        logger.info("updated records by quartz job $updatedUrlRecords")

        urlCheckResultRepository.saveAll(updatedUrlRecords)
    }
}

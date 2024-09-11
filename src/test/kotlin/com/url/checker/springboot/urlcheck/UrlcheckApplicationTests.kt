package com.url.checker.springboot.urlcheck

import org.junit.jupiter.api.Test
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootTest
@EnableJpaRepositories(basePackages = ["com.url.checker.springboot.urlcheck.repository"])
@EntityScan(basePackages = ["com.url.checker.springboot.urlcheck.model"])
class UrlcheckApplicationTests {

	@Test
	fun contextLoads() {
	}

}

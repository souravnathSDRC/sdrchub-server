package com.sdrc.sdrchub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("com.sdrc.sdrchub.domain")
@EnableJpaRepositories("com.sdrc.sdrchub.repository")
public class SdrcHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdrcHubApplication.class, args);
	}
}

package com.sdrc.sdrchub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("com.sdrc.sdrchub.domain")
@EnableJpaRepositories("com.sdrc.sdrchub.repository")
@PropertySource(value = { "classpath:messages.properties" })
public class SdrcHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(SdrcHubApplication.class, args);
	}
	
	
	@Bean
	MessageDigestPasswordEncoder messageDigestPasswordEncoder(){
		return new MessageDigestPasswordEncoder("SHA-1");
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages");
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
		
	}
	
}

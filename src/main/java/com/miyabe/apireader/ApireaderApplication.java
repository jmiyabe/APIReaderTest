package com.miyabe.apireader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableCaching
public class ApireaderApplication {

	@Bean
	public WebClient webClient(WebClient.Builder builder) {
		return builder.baseUrl(Constants.URL).build();
	}

	public static void main(String[] args) {
		SpringApplication.run(ApireaderApplication.class, args);
	}

}

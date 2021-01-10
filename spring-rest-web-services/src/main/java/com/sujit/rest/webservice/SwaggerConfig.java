package com.sujit.rest.webservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Adding Swagger Documentation support for 
 * the exposed resources.
 * 
 * URL's to be checked for documentation - 
 * 1. http://localhost:8080/v2/api-docs
 * 2. http://localhost:8080/swagger-ui/index.html
 */
//Configuration - to tell its a Spring Bean
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}

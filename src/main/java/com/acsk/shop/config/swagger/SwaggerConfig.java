package com.acsk.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import static com.google.common.base.Predicates.or;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.acsk.shop.controller"))
				//.paths(regex("/shop.*"))
                .paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Shop REST API", "Shop REST API for Developers", "1.0",
				"Terms of service",
				new Contact("Chandrakant Audhutwar", "https://fb.me/iam.chandrakant", "ca03430@gmail.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0");
		//return apiInfo;

		return new ApiInfoBuilder()
				.title("Shop REST API")
				.description("Shop REST API for Developers")
				.termsOfServiceUrl("https://fb.me/iam.chandrakant")
				.contact("Chandrakant Audhutwar")
				.license("Apache License Version 2.0")
				.licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
				.version("1.0")
				.build();
	}

}
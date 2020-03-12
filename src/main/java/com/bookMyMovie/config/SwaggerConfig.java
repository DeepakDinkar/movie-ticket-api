package com.bookMyMovie.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.AuthorizationScopeBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings("deprecation")
@Configuration
@EnableSwagger2
public class SwaggerConfig extends WebMvcConfigurerAdapter {

	@Bean
	public Docket api() {

		AuthorizationScope[] authScopes = new AuthorizationScope[1];
		authScopes[0] = new AuthorizationScopeBuilder().scope("global").description("full access").build();
		SecurityReference securityReference = SecurityReference.builder().reference("X-API-KEY").scopes(authScopes)
				.build();

		ArrayList<SecurityContext> securityContexts = new ArrayList<>(Arrays.asList(SecurityContext.builder()
				.securityReferences(new ArrayList<>(Arrays.asList(securityReference))).build()));

		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(new ArrayList<ApiKey>(Arrays.asList(new ApiKey("X-API-KEY", "x-api-key", "header"))))
				.securityContexts(securityContexts).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger API Security REST API")
				.description("\"Swagger API Security REST API\"").version("1.0.0").build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}

package com.agrobaires.agrobaires.conf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() throws FileNotFoundException, IOException {
		return new Docket(DocumentationType.SWAGGER_2)
				.securityContexts(Arrays.asList(securityContext()))
				.securitySchemes(Arrays.asList(apiKey()))
				.useDefaultResponseMessages(false).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.ant("/**")).build().apiInfo(getMetadata());
	}

	private ApiInfo getMetadata() throws FileNotFoundException, IOException {

		ApiInfo apiInfo = new ApiInfo("Portal de productos para el campo",
				"Portal de productos para el campo",
				"v1.0.1",
				"",
				new Contact("Agrobaires",
						"https://www.agrobaires.com.ar",
						"soporte@agrobaires.com.ar"),
				"Agrobaires S.R.L.", "", new ArrayList<>());
		return apiInfo;
	}

	@Bean
	public UiConfiguration tryItOutConfig() {
		final String[] methodsWithTryItOutButton = { "get", "post", "put", "delete", "patch" };
		return UiConfigurationBuilder.builder().supportedSubmitMethods(methodsWithTryItOutButton).build();
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("JWT", authorizationScopes));
	}
}

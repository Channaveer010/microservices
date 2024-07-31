package com.university.course.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

	@Bean
	public GroupedOpenApi courseApi() {
		return GroupedOpenApi.builder().group("courses").pathsToMatch("/v1/courses/api/**").build();
	}
}

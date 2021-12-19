package de.viadee.api.roundtrip.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
	info = @Info(
		title = "API Demo",
		description = "An API showcase demonstrating how to automatically generate an OpenAPI spec and client code.",
		version = "0.1.0",
		contact = @Contact(
			name = "Cloud @example",
			url = "https://www.example.com",
			email = "cloud@example.com"),
		license = @License(
			name = "BSD 3-Clause License",
			url = "https://github.com/example/api-roundtrip-spring-boot/blob/main/LICENSE")),
	servers = @Server(url = "http://localhost:8080"))
class OpenAPIConfiguration {
}
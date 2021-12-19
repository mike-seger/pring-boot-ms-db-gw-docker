package com.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@Data
@RequiredArgsConstructor
@EnableConfigurationProperties
@ConfigurationProperties("app.gateway")
public class IndexController {
	private String basePath;
	private String routesUrl;

	@Autowired
	private GatewayRoutes gatewayRoutes;

	@Data @AllArgsConstructor
	public static class ServerInfo {
		String name;
		String root;
		String actuator;
		String api;
	}

	@Configuration
	@Data @AllArgsConstructor @NoArgsConstructor
	@ConfigurationProperties("spring.cloud.gateway")
	public static class GatewayRoutes {
		List<GatewayRoute> routes;
		@Data @AllArgsConstructor @NoArgsConstructor
		public static class GatewayRoute {
			List<String> predicates;
		}
	}

	@GetMapping({"/", "${app.gateway.base-path}"})
	public String home(Model model) {
		var paths = gatewayRoutes.routes.stream()
			.flatMap(
					route -> route.predicates.stream())
				.filter(p -> p.startsWith("Path="))
				.map(p -> p.replaceAll("Path=", "")
					.replaceAll("/*[*]*$", ""))
				.collect(Collectors.toList());
		model.addAttribute("serverInfo", paths.stream().map(path ->
			new ServerInfo(
					path.replaceAll(".*/", ""),
				path+"/", path + "/actuator/", path + "/swagger-ui.html"))
				.collect(Collectors.toList()));
			return "index";
	}
}

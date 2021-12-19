package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@RestController
public class DebugController {
	@GetMapping("/headers")
	public Mono<ServerResponse> headers(ServerRequest request) {
		return ServerResponse.ok().bodyValue(request.headers().asHttpHeaders());
	}
}

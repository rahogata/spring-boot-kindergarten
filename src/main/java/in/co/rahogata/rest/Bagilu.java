package in.co.rahogata.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class Bagilu {

	@GetMapping("/")
	public Mono<String> index() {
		return Mono.just("Greetings from Spring Boot using!");
	}

	@GetMapping("/l")
	public Mono<String> lazy() {
		return Mono.fromSupplier(() -> "Greetings from Spring Boot using!");
	}
}

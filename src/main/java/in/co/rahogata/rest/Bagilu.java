package in.co.rahogata.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.ServletRequest;

@RestController
public class Bagilu {

	@GetMapping("/")
	public String index(ServletRequest request) {
		return "Greetings from Spring Boot using " + request.getProtocol() + "!";
	}
}

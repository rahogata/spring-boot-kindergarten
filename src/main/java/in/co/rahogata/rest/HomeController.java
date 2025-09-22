package in.co.rahogata.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.rahogata.scheduler.TaskExecutorExample;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class HomeController {
	
	private final TaskExecutorExample taskExecutorExample;

	@GetMapping("/print")
	public void print() {
		taskExecutorExample.printMessages();
	}
}

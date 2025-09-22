package in.co.rahogata.scheduler;

import java.net.URI;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class TrySchedulerService2 {
	
	private final RestTemplate restTemplate;

	@Scheduled(cron = "0/4 * * * * ?")
	public void sendRequest() {
		log.info("> srequest3");
		restTemplate.getForEntity(URI.create("https://httpbin.org/delay/10"), String.class);
		log.info("<sresp3");
	}
	
	@Scheduled(cron = "0/4 * * * * ?")
	public void sendRequest2() {
		log.info("> srequest4");
		restTemplate.getForEntity(URI.create("https://httpbin.org/delay/10"), String.class);
		log.info("<sresp4");
	}
}

package in.co.rahogata.virtualthreads.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@Slf4j
@RestController
@RequestMapping("/load")
public class LoadTestController {

    @GetMapping
    public void tryApi() throws InterruptedException {
        log.info("doing something");
        Thread.sleep(Duration.ofSeconds(1));
    }
}

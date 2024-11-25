package in.co.rahogata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class Dwara implements CommandLineRunner {

    @Autowired
    private RedisJsonProperties redisJsonProperties;

    public static void main(String[] args) {
        SpringApplication.run(Dwara.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Bean = {}", redisJsonProperties.getClass().getName());
        log.info("Host = {}", redisJsonProperties.getHost());
        log.info("Port = {}", redisJsonProperties.getPort());
    }
}

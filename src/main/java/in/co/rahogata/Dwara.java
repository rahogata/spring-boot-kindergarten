package in.co.rahogata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Dwara {

    public static void main(String[] args) {
        SpringApplication.run(Dwara.class, args);
    }
}

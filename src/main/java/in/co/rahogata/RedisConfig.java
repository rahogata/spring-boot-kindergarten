package in.co.rahogata;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {
    @Bean("controllerDbProperties")
    @ConfigurationProperties(prefix = "controller.db.redis")
    public RedisJsonProperties ctlrRedisJsonProperties() {
        return new RedisJsonProperties();
    }

    @Bean("edgeDbProperties")
    @ConfigurationProperties(prefix = "edge.db.redis")
    public RedisJsonProperties edgeRedisJsonProperties() {
        return new RedisJsonProperties();
    }
}

package in.co.rahogata;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.Map;


@Configuration
@EnableCaching
public class RedisRouteConfig {

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(ThreadLocalRedisRouter threadLocalRedisRouter, RedisProperties redisProperties) {
        return new RoutingJedisConnectionFactory(Map.of("a", newJedisFactory(redisProperties, "localhost", 6379)
        , "b", newJedisFactory(redisProperties, "localhost", 6380)), threadLocalRedisRouter);
    }

    @Bean
    public ThreadLocalRedisRouter threadLocalRedisRouter() {
        return new ThreadLocalRedisRouter();
    }

    private JedisConnectionFactory newJedisFactory(RedisProperties redisProperties, String host, int port) {
        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(host);
        config.setPort(port);
        config.setDatabase(redisProperties.getDatabase());
        return new JedisConnectionFactory(config, JedisClientConfiguration.builder().build());
    }
}

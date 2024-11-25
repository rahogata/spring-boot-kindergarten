package in.co.rahogata;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "edge.db.redis", name = "host")
@ConfigurationProperties(prefix = "edge.db.redis")
public class EdgeRedisJsonProperties extends RedisJsonProperties {
}

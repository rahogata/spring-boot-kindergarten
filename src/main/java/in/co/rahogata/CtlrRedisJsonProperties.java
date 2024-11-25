package in.co.rahogata;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "controller.db.redis", name = "host")
@ConfigurationProperties(prefix = "controller.db.redis")
public class CtlrRedisJsonProperties extends RedisJsonProperties {
}

package in.co.rahogata;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;

@Setter
@Getter
@ConfigurationProperties(prefix = "app.redis.ssl")
public class AppRedisSslProperties {
    private Resource keyStoreLocation;
    private char[] keyStorePassword;
    private Resource trustStoreLocation;
    private char[] trustStorePassword;
    private String keyStoreType;
    private boolean verifyPeer;
}

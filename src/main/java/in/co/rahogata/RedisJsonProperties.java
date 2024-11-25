package in.co.rahogata;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
public class RedisJsonProperties {
    private String host;
    private int port;
}

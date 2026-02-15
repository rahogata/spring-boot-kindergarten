package in.co.rahogata.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "webauthn")
public class WebAuthNProperties {
    private String allowedOrigins;
    private String rpId;
    private String rpName;
}

package in.co.rahogata.config;


import in.co.rahogata.annotation.ConditionalOnEnablePrint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@ConditionalOnEnablePrint
@Configuration
public class PrintConfig {

    @Bean("printConfigs")
    public Map<String, String> printConfigs() {
        return Map.of("a", "b", "c", "d");
    }
}

package in.co.rahogata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class DwaraDharaka {
    @Bean
    SecurityFilterChain webauthnFilterChain(HttpSecurity http, WebAuthNProperties webAuthNProperties) {
        return http.authorizeHttpRequests( ht -> ht.anyRequest().authenticated())
                .formLogin(withDefaults())
                .webAuthn(webauth ->
                        webauth.allowedOrigins(webAuthNProperties.getAllowedOrigins())
                                .rpId(webAuthNProperties.getRpId())
                                .rpName(webAuthNProperties.getRpName())
                )
                .build();
    }
}

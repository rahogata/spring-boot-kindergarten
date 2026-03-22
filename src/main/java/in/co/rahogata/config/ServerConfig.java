package in.co.rahogata.config;

import org.springframework.boot.reactor.netty.NettyReactiveWebServerFactory;
import org.springframework.boot.ssl.SslBundle;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.netty.http.Http3SslContextSpec;
import reactor.netty.http.HttpProtocol;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

@Configuration
public class ServerConfig {

	@Bean
    WebServerFactoryCustomizer<NettyReactiveWebServerFactory> nettyServerCustomizer() throws IOException {
		return factory -> {
            factory.addServerCustomizers(server -> {
                SslBundle sslBundle = Objects.requireNonNull(factory.getSslBundles()).getBundle("server");
                Http3SslContextSpec sslContextSpec =
                        Http3SslContextSpec.forServer(sslBundle.getManagers().getKeyManagerFactory(), sslBundle.getKey().getPassword());

                return server
                        // Configure HTTP/3 protocol
                        .protocol(HttpProtocol.HTTP3)
                        // Configure HTTP/3 SslContext
                        .secure(spec -> spec.sslContext(sslContextSpec))
                        // Configure HTTP/3 settings
                        .http3Settings(spec -> spec.idleTimeout(Duration.ofSeconds(5))
                                .maxData(10_000_000)
                                .maxStreamDataBidirectionalRemote(1_000_000)
                                .maxStreamsBidirectional(100));
            });
		};
	}
}

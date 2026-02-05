package in.co.rahogata.config;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.jetty.http3.server.HTTP3ServerConnectionFactory;
import org.eclipse.jetty.quic.server.QuicServerConnector;
import org.eclipse.jetty.quic.server.ServerQuicConfiguration;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.SecureRequestCustomizer;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ssl.DefaultSslBundleRegistry;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerConfig {

	@Bean
	WebServerFactoryCustomizer<JettyServletWebServerFactory> jettyServerCustomizer(DefaultSslBundleRegistry defaultSslBundleRegistry,
			@Value("${server.port:8080}") Integer serverPort) throws IOException {
		Path workDir = Path.of("quic-workdir");
        Files.createDirectories(workDir);
		return factory -> {
			factory.addServerCustomizers(server -> {
				var keyStore = defaultSslBundleRegistry.getBundle("server").getStores().getKeyStore();

                SslContextFactory.Server sslContextFactory = new SslContextFactory.Server();
                sslContextFactory.setKeyStore(keyStore);
                sslContextFactory.setKeyStorePassword("changeit");

                HttpConfiguration httpConfig = new HttpConfiguration();
                httpConfig.addCustomizer(new SecureRequestCustomizer());
//                httpConfig.setIdleTimeout(idleTimeout);
                ServerQuicConfiguration quicConfig = new ServerQuicConfiguration(sslContextFactory, workDir);
                HTTP3ServerConnectionFactory http3 = new HTTP3ServerConnectionFactory(quicConfig);
                QuicServerConnector quicConnector = new QuicServerConnector(server, quicConfig, http3);
                
                quicConnector.setPort(serverPort);
                server.addConnector(quicConnector);
			});
		};
	}
}

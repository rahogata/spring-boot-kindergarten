package in.co.rahogata.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private CertWebSocketHandler certWebSocketHandler;
    
    @Autowired
    public WebSocketConfig(CertWebSocketHandler certWebSocketHandler) {
        this.certWebSocketHandler = certWebSocketHandler;
    }
    
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(certWebSocketHandler, "/certsocket");
    }
}

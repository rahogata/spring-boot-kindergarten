package in.co.rahogata.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import in.co.rahogata.service.impl.CertProviderImpl;

@Component
public class CertWebSocketHandler extends TextWebSocketHandler {

    private static final Logger LOG = LoggerFactory.getLogger(CertWebSocketHandler.class);
    private WebSocketSession session;
    private CertProviderImpl certProviderImpl;

    @Autowired
    public CertWebSocketHandler(CertProviderImpl certProviderImpl) {
        this.certProviderImpl = certProviderImpl;
    }

    public WebSocketSession getSession() {
        return session;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        if ("1".equals(message.getPayload())) {
            session.sendMessage(new TextMessage(certProviderImpl.getCert()));
        }
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        this.session = session;
        LOG.info("Connection has established for {}", session);
    }
    
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        // TODO Auto-generated method stub
        super.afterConnectionClosed(session, status);
        LOG.info("Connection closed by {}", session);
    }
}

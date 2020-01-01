package in.co.rahogata.service.impl;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import in.co.rahogata.config.CertWebSocketHandler;

@Service
public class CertServiceImpl {

    private static final Logger LOG = LoggerFactory.getLogger(CertServiceImpl.class);

    private CertProviderImpl certProviderImpl;
    private CertWebSocketHandler certWebSocketHandler;
    
    @Autowired
    public CertServiceImpl(CertProviderImpl certSessionServiceImpl, CertWebSocketHandler certWebSocketHandler) {
        this.certProviderImpl = certSessionServiceImpl;
        this.certWebSocketHandler = certWebSocketHandler;
    }

    public void sendCertificates(String cert) throws IOException {
        certProviderImpl.setCert(cert);
        WebSocketSession session = certWebSocketHandler.getSession();
        if (session != null) {
            session.sendMessage(new TextMessage(cert));
            return;
        }
        LOG.error("No web socket session is opened by the downloader");
    }
}

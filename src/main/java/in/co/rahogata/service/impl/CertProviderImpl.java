package in.co.rahogata.service.impl;

import org.springframework.stereotype.Service;

@Service
public class CertProviderImpl {

    private String cert = "-1";

    public void setCert(String cert) {
        this.cert = cert;
    }

    public String getCert() {
        return cert;
    }
}

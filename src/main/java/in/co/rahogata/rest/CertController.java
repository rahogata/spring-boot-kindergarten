package in.co.rahogata.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import in.co.rahogata.service.impl.CertServiceImpl;

@Controller
@RequestMapping("/cert")
public class CertController {

    private CertServiceImpl certServiceImpl;

    @Autowired
    public CertController(CertServiceImpl certServiceImpl) {
        this.certServiceImpl = certServiceImpl;
    }

    @PostMapping
    public ResponseEntity<Void> sendNewCert(@RequestBody String certificate) throws IOException {
        certServiceImpl.sendCertificates(certificate);
        return ResponseEntity.ok().build();
    }
}

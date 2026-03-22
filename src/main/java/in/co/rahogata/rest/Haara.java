package in.co.rahogata.rest;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Haara {

    @GetMapping
    public String home(HttpServletRequest request) {
        return "Haara to " + request.getProtocol();
    }
}

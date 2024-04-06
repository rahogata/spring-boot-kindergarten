package in.co.rahogata.resttemplate;

import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

class NoGenericFetchTest {

    @Data
    private static class HttpbinResponse {
        private Map<String, String> headers;
    }

    @Test
    void fetchNoGenericType(TestReporter reporter) {
        RestTemplate r = new RestTemplate();
        ResponseEntity<HttpbinResponse> response = r.exchange("http://httpbin.org/headers", HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        System.out.println(response.getBody());
    }
}

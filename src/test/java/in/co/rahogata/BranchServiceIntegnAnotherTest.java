package in.co.rahogata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Contexts are used across the test classes even in integrated tests.
 * @author shiva
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class BranchServiceIntegnAnotherTest {

    private TestRestTemplate testRestTemplate;
    
    @Autowired
    public BranchServiceIntegnAnotherTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }
    
    @Test
    public void testInstanceCount() {
        ResponseEntity<InstanceCount> countResponse = testRestTemplate.getForEntity("/branches/count", InstanceCount.class);
        assertEquals(HttpStatus.OK, countResponse.getStatusCode());
        System.out.println("Branch Integn Test ************** " + countResponse.getBody());
    }
}

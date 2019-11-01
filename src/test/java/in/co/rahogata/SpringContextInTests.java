package in.co.rahogata;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SpringContextInTests {

    @Test
    public void testA() {
        System.out.println("<<<<<<<<<<<<<<<<< testA");
    }
    
    @Test
    public void testB() {
        System.out.println("<<<<<<<<<<<<<<<<< testB");
    }
    
    @Test
    public void testC() {
        System.out.println("<<<<<<<<<<<<<<<<< testC");
    }
    
    @Test
    public void testD() {
        System.out.println("<<<<<<<<<<<<<<<<< testD");
    }
    
    @Test
    public void testE() {
        System.out.println("<<<<<<<<<<<<<<<<< testE");
    }
    
    @Test
    public void testF() {
        System.out.println("<<<<<<<<<<<<<<<<< testF");
    }
    
    @Test
    public void testG() {
        System.out.println("<<<<<<<<<<<<<<<<< testG");
    }
}

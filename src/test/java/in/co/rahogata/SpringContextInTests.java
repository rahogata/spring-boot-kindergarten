package in.co.rahogata;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SpringContextInTests {

    @Autowired
    LeafService leafService;
    
    @Test
    public void testA() {
        System.out.println("<<<<<<<<<<<<<<<<< testA = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testB() {
        System.out.println("<<<<<<<<<<<<<<<<< testB = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testC() {
        System.out.println("<<<<<<<<<<<<<<<<< testC = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testD() {
        System.out.println("<<<<<<<<<<<<<<<<< testD = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testE() {
        System.out.println("<<<<<<<<<<<<<<<<< testE = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testF() {
        System.out.println("<<<<<<<<<<<<<<<<< testF = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testG() {
        System.out.println("<<<<<<<<<<<<<<<<< testG = " + leafService.getNoOfInstances() + " " + leafService);
    }
}

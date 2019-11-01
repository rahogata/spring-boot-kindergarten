package in.co.rahogata;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SpringContextInOtherTests {

    @Test
    public void testOtherA() {
        System.out.println(">>>>>>>>>>>>>>> testOtherA");
    }
    
    @Test
    public void testOtherB() {
        System.out.println(">>>>>>>>>>>>>>> testOtherB");
    }
    
    @Test
    public void testOtherC() {
        System.out.println(">>>>>>>>>>>>>>> testOtherA");
    }
    
    @Test
    public void testOtherD() {
        System.out.println(">>>>>>>>>>>>>>> testOtherD");
    }
    
    @Test
    public void testOtherE() {
        System.out.println(">>>>>>>>>>>>>>> testOtherE");
    }
    
    @Test
    public void testOtherF() {
        System.out.println(">>>>>>>>>>>>>>> testOtherF");
    }
    
    @Test
    public void testOtherG() {
        System.out.println(">>>>>>>>>>>>>>> testOtherG");
    }
}

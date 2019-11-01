package in.co.rahogata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class SpringContextInOtherTests extends GeneralTestSuite {

    @Autowired
    LeafService leafService;
    
    @Test
    public void testOtherA() {
        System.out.println(">>>>>>>>>>>>>>> testOtherA = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testOtherB() {
        System.out.println(">>>>>>>>>>>>>>> testOtherB = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testOtherC() {
        System.out.println(">>>>>>>>>>>>>>> testOtherA = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testOtherD() {
        System.out.println(">>>>>>>>>>>>>>> testOtherD = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testOtherE() {
        System.out.println(">>>>>>>>>>>>>>> testOtherE = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testOtherF() {
        System.out.println(">>>>>>>>>>>>>>> testOtherF = " + leafService.getNoOfInstances() + " " + leafService);
    }
    
    @Test
    public void testOtherG() {
        System.out.println(">>>>>>>>>>>>>>> testOtherG = " + leafService.getNoOfInstances() + " " + leafService);
    }
}

package in.co.rahogata;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class LeafService {

    private static int noInstances = 0;
    

    @PostConstruct
    public void init() {
        noInstances += 1;
    }
    
    public int getNoOfInstances() {
        return noInstances;
    }
}

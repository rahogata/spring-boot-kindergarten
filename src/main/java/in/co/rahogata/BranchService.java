package in.co.rahogata;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    private static int noInstances = 0;
    
    private LeafService leafService;
    
    @Autowired
    public BranchService(LeafService leafService) {
        this.leafService = leafService;
    }
    
    @PostConstruct
    public void init() {
        noInstances += 1;
    }
    
    public int getNoInstances() {
        return noInstances;
    }
    
    public InstanceCount fetchInstancesCount() {
        return new InstanceCount(getNoInstances(), leafService.getNoOfInstances());
    }
}

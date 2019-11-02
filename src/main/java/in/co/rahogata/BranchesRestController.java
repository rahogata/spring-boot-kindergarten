package in.co.rahogata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branches")
public class BranchesRestController {

    private BranchService branchService;
    
    @Autowired
    public BranchesRestController(BranchService branchService) {
        this.branchService = branchService;
    }
    
    @GetMapping("/count")
    public InstanceCount giveInstancesCount() {
        return branchService.fetchInstancesCount();
    }
}

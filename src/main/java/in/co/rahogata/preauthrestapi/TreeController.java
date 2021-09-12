package in.co.rahogata.preauthrestapi;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/trees")
public class TreeController {
    
    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('trees')")
    public Tree getByName(@PathVariable String name) {
        log.info("getByName > {}", SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        return new Tree(name);
    }

    @GetMapping("/leaves/{type}")
    public Tree getTreeByLeaves(String type) {
        return new Tree("tree");
    }
}

package in.co.rahogata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cached")
public class CacheController {

    private final CacheTryService cacheTryService;

    @GetMapping
    public String getVal() {
        return cacheTryService.getVal("b");
    }
}

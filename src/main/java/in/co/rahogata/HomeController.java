package in.co.rahogata;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cache")
public class HomeController {

    private final CachingService cachingService;

    @GetMapping("/r1")
    public String getCachedA(String k, String v) throws InterruptedException {
        return cachingService.getR1(k);
    }

    @GetMapping("/r2")
    public String getCachedB(String k, String v) throws InterruptedException {
        return cachingService.getR2(k);
    }
}

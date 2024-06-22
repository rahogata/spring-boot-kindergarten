package in.co.rahogata;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class CacheTryService {

    @Cacheable("cts")
    public String getVal(String key) {
        return "fkdf" + Math.random();
    }
}

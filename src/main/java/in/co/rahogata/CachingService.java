package in.co.rahogata;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CachingService {

    @RoutingCacheable(value = "multi", redisServiceName = "a")
    public String getR1(String k) throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        return String.valueOf(Math.random());
    }

    @RoutingCacheable(value = "multi", redisServiceName = "b")
    public String getR2(String k) throws InterruptedException {
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        return String.valueOf(Math.random());
    }
}

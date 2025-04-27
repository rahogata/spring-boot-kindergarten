package in.co.rahogata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.SimpleCacheResolver;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component("routingCacheResolver")
public class RoutingCacheResolver extends SimpleCacheResolver {

    private final ThreadLocalRedisRouter threadLocalRedisRouter;

    public RoutingCacheResolver(CacheManager cacheManager, ThreadLocalRedisRouter threadLocalRedisRouter) {
        super(cacheManager);
        this.threadLocalRedisRouter = threadLocalRedisRouter;
    }

    @Override
    public Collection<? extends Cache> resolveCaches(CacheOperationInvocationContext<?> context) {
        threadLocalRedisRouter.setCurrentKey(context.getMethod().getAnnotation(RoutingCacheable.class).redisServiceName());
        log.info("redis set to.... {}", threadLocalRedisRouter.getKey());
        return super.resolveCaches(context);
    }
}

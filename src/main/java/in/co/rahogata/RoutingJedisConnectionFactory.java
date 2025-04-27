package in.co.rahogata;

import lombok.RequiredArgsConstructor;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisSentinelConnection;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
public class RoutingJedisConnectionFactory extends JedisConnectionFactory {
    private final Map<String, JedisConnectionFactory> factory;
    private final ThreadLocalRedisRouter threadLocalRedisRouter;

    private JedisConnectionFactory choose() {
        JedisConnectionFactory f = factory.get(threadLocalRedisRouter.getKey());
        if (null == f) {
            throw new IllegalStateException("factory not found");
        }
        return f;
    }

    @Override
    public void afterPropertiesSet() {
        factory.forEach((k, v) -> v.afterPropertiesSet());
    }

    @Override
    public void destroy() {
        choose().destroy();
    }

    @Override
    public RedisConnection getConnection() {
        return choose().getConnection();
    }

    @Override
    public RedisClusterConnection getClusterConnection() {
        return choose().getClusterConnection();
    }

    @Override
    public DataAccessException translateExceptionIfPossible(RuntimeException ex) {
        return choose().translateExceptionIfPossible(ex);
    }

    @Override
    public String getHostName() {
        return choose().getHostName();
    }

    @Override
    public void setHostName(String hostName) {
        choose().setHostName(hostName);
    }

    @Override
    public boolean isUseSsl() {
        return choose().isUseSsl();
    }

    @Override
    public void setUseSsl(boolean useSsl) {
        choose().setUseSsl(useSsl);
    }

    @Override
    public String getPassword() {
        return choose().getPassword();
    }

    @Override
    public void setPassword(String password) {
        choose().setPassword(password);
    }

    @Override
    public int getPort() {
        return choose().getPort();
    }

    @Override
    public void setPort(int port) {
        choose().setPort(port);
    }

    @Override
    public JedisShardInfo getShardInfo() {
        return choose().getShardInfo();
    }

    @Override
    public void setShardInfo(JedisShardInfo shardInfo) {
        choose().setShardInfo(shardInfo);
    }

    @Override
    public int getTimeout() {
        return choose().getTimeout();
    }

    @Override
    public void setTimeout(int timeout) {
        choose().setTimeout(timeout);
    }

    @Override
    public boolean getUsePool() {
        return choose().getUsePool();
    }

    @Override
    public void setUsePool(boolean usePool) {
        choose().setUsePool(usePool);
    }

    @Override
    public GenericObjectPoolConfig<Jedis> getPoolConfig() {
        return choose().getPoolConfig();
    }

    @Override
    public void setPoolConfig(JedisPoolConfig poolConfig) {
        choose().setPoolConfig(poolConfig);
    }

    @Override
    public int getDatabase() {
        return choose().getDatabase();
    }

    @Override
    public void setDatabase(int index) {
        choose().setDatabase(index);
    }

    @Override
    public String getClientName() {
        return choose().getClientName();
    }

    @Override
    public void setClientName(String clientName) {
        choose().setClientName(clientName);
    }

    @Override
    public JedisClientConfiguration getClientConfiguration() {
        return choose().getClientConfiguration();
    }

    @Override
    public RedisStandaloneConfiguration getStandaloneConfiguration() {
        return choose().getStandaloneConfiguration();
    }

    @Override
    public RedisSentinelConfiguration getSentinelConfiguration() {
        return choose().getSentinelConfiguration();
    }

    @Override
    public RedisClusterConfiguration getClusterConfiguration() {
        return choose().getClusterConfiguration();
    }

    @Override
    public boolean getConvertPipelineAndTxResults() {
        return choose().getConvertPipelineAndTxResults();
    }

    @Override
    public void setConvertPipelineAndTxResults(boolean convertPipelineAndTxResults) {
        choose().setConvertPipelineAndTxResults(convertPipelineAndTxResults);
    }

    @Override
    public boolean isRedisSentinelAware() {
        return choose().isRedisSentinelAware();
    }

    @Override
    public boolean isRedisClusterAware() {
        return choose().isRedisClusterAware();
    }

    @Override
    public RedisSentinelConnection getSentinelConnection() {
        return choose().getSentinelConnection();
    }
}

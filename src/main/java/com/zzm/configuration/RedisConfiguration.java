package com.zzm.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Slf4j
@Configuration
public class RedisConfiguration {

  @Value("${redis.uri}")
  private String uri;

  @Value("${redis.pool.maxIdle}")
  private Integer maxIdle;

  @Value("${redis.pool.maxWait}")
  private Long maxWait;

  @Value("${redis.pool.timeout}")
  private Integer timeout;


  @Bean
  public JedisPool redisPoolFactory() {
    JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
    jedisPoolConfig.setMaxIdle(maxIdle);
    jedisPoolConfig.setMaxWaitMillis(maxWait);
    JedisPool jedisPool = new JedisPool(jedisPoolConfig,uri);
    return jedisPool;
  }

}

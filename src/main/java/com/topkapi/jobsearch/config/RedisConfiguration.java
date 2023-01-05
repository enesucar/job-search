package com.topkapi.jobsearch.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
public class RedisConfiguration {
    @Bean
    public RedisCacheConfiguration cacheConfiguration() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .disableCachingNullValues()
                    .entryTtl(Duration.ofDays(1))
                        .serializeValuesWith(RedisSerializationContext
                            .SerializationPair
                                .fromSerializer(new GenericJackson2JsonRedisSerializer()));
    }
}

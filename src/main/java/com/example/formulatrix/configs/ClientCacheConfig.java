package com.example.formulatrix.configs;

import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.NearCacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@EnableCaching
@Profile("client")
public class ClientCacheConfig {
    @Bean
    ClientConfig config() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.addNearCacheConfig(nearCacheConfig());
        return clientConfig;
    }

    private NearCacheConfig nearCacheConfig() {
        NearCacheConfig nearCacheConfig = new NearCacheConfig();
        nearCacheConfig.setName("contents");
        nearCacheConfig.setTimeToLiveSeconds(10000);
        return nearCacheConfig;
    }
}
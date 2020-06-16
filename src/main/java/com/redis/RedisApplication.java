package com.redis;

import com.redis.redis.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@Slf4j
@EnableCaching
public class RedisApplication implements CommandLineRunner {
    @Autowired
    CacheService cacheService;

    public static void main(String[] args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    @Override
    public void run(String... args) {
        String firstString = cacheService.cacheThis();
        log.info("First: {}", firstString);
        String secondString = cacheService.cacheThis();
        log.info("Second: {}", secondString);
    }

}

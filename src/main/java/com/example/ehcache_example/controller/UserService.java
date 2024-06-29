package com.example.ehcache_example.controller;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Cacheable(value = "employeeCache", key = "#userId")
    public String getUserById(long userId) {
        // Simulate a slow service call
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "User_" + userId;
    }

    @Cacheable(value = "configCache", key = "'configList'")
    public List<String> getConfigList() {
        // Simulate fetching config data
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList("Config1", "Config2", "Config3");
    }

    @CacheEvict(value = "configCache", key = "'configList'")
    public void evictConfigListCache() {
        // This method will be used to evict the cache
    }
}

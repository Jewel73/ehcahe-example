package com.example.ehcache_example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public String getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/config")
    public List<String> getConfigList() {
        return userService.getConfigList();
    }

    @GetMapping("/config/evict")
    public String evictConfigCache() {
        userService.evictConfigListCache();
        return "Config cache evicted";
    }
}

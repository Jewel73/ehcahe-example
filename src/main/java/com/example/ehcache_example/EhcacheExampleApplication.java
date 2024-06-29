package com.example.ehcache_example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class EhcacheExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EhcacheExampleApplication.class, args);
	}

}

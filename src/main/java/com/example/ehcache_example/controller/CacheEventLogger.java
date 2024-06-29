package com.example.ehcache_example.controller;

import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class CacheEventLogger
        implements CacheEventListener<Object, Object> {

    // ...

    @Override
    public void onEvent(
            CacheEvent<? extends Object, ? extends Object> cacheEvent) {
        System.out.print(
                cacheEvent.getKey()+ " "+ cacheEvent.getOldValue()+ " "+cacheEvent.getNewValue());
    }
}
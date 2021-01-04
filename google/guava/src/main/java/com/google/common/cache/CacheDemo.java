package com.google.common.cache;

import java.util.concurrent.TimeUnit;

/**
 * Google缓存工具类，构建内存缓存
 *
 */
public class CacheDemo {
    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder().initialCapacity(100).maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES).build();

        cache.put("key1", "value1");

        String value = cache.getIfPresent("key1");
        System.out.println(value);
    }
}

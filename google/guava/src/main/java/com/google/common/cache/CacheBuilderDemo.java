package com.google.common.cache;

import java.util.concurrent.TimeUnit;

/**
 * Google缓存工具类，构建内存缓存
 * 可以设置缓存的大小，超时时间，
 * 可以自动回收缓存中的对象，不会导致JVM的OOM内存溢出.
 */
public class CacheBuilderDemo {
    public static void main(String[] args) {
        // createCacheWithBasicConfig();
        createLoadingCache();
    }

    /**
     * 1.演示缓存基本配置
     */
    public static void createCacheWithBasicConfig() {
        // 缓存初始大小100，最大缓存数量10000，10分钟后缓存失效
        Cache<String, String> cache = CacheBuilder.newBuilder().initialCapacity(100).maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES).build();

        cache.put("key1", "value1");

        String value = cache.getIfPresent("key1");
        System.out.println(value);
    }

    /**
     * 2.缓存在找不到的时候，会自动加载，而不需要实现put进去。
     */
    public static void createLoadingCache() {
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder().weakKeys().weakValues()
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(final String key) {
                        return loadAdapter(key);
                    }
                });
    }

    private static Object loadAdapter(String key) {
        // 从其他地方加载缓存，比如数据库或者配置文件
        return null;
    }
}

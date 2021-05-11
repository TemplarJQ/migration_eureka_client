package com.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.service.CacheService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Service
public class CacheServiceImpl implements CacheService {

    private Cache<String, Object> commonCache = null;

    //本地缓存服务及其实现，针对大访问场景选择开启，压测实验等
    @PostConstruct
    public void init(){
        commonCache = CacheBuilder.newBuilder()
                //初始容量
                .initialCapacity(10)
                //设置缓存最大存储100个key，超过100使用LRU操作
                .maximumSize(100)
                //写入失效时间，写入缓存后多久失效
                .expireAfterWrite(60, TimeUnit.SECONDS).build();

    }

    @Override
    public void serCommonCache(String key, Object value) {
        commonCache.put(key, value);
    }

    @Override
    public Object getFromCommonCache(String key) {
        return commonCache.getIfPresent(key);
    }
}
